package org.lingBotTeam.lingBot.event;

import org.lingBotTeam.lingBot.LingBot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

// 思路来源于Bukkit的Event系统
// 当然, 这里用了部分LiquidBounce的方法来实现 :D
public class EventManager {
    protected final ConcurrentHashMap<Class<? extends Event>, LinkedList<Registry>> eventListener = new ConcurrentHashMap<>();

    public void registerListener(Listener listener) {
        searchListener(listener);
    }

    void searchListener(Listener listener) {
        Class<? extends Listener> clzListener = listener.getClass();
        for (Method method : clzListener.getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                Class<?>[] types = method.getParameterTypes();
                if (types.length != 1) continue;
                Class<?> clzType = types[0];
                if (!Event.class.isAssignableFrom(clzType)) continue;
                final Class<? extends Event> clzEvent = clzType.asSubclass(Event.class);
                LinkedList<Registry> regList = eventListener.computeIfAbsent(clzEvent, k -> new LinkedList<>());
                regList.add(new Registry(listener, method, clzEvent));
            }
        }
    }

    public void callEvent(Event event) {
        LinkedList<Registry> regEventListener = eventListener.get(event.getClass());
        if (regEventListener == null) return;
        for (Registry registry : regEventListener) {
            try {
                registry.invoke(event);
            } catch (InvocationTargetException | IllegalAccessException e) {
                Throwable t = e.getCause();
                LingBot.getInstance().getMessageManager().MANAGER_GROUP.sendMessage("Exception occluding " + t.getMessage() + "\n" + t.toString());
            }
        }
    }

    public static class Registry {
        private final Listener handleListener;
        private final Method method;
        private final Class<? extends Event> listeningEventClass;
        public Registry(Listener listener, Method method, Class<? extends Event> clzEvent) {
            handleListener = listener;
            this.method = method;
            this.listeningEventClass = clzEvent;
            method.setAccessible(true);
        }

        public void invoke(Event event) throws InvocationTargetException, IllegalAccessException {
            method.invoke(handleListener, event);
        }

        public Class<? extends Event> getListeningEventClass() {
            return listeningEventClass;
        }
    }
}
