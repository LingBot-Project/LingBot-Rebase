package org.lingBotTeam.lingBot;

import org.lingBotTeam.lingBot.event.EventManager;
import org.lingBotTeam.lingBot.event.events.botEvent.BotEnableEvent;
import org.lingBotTeam.lingBot.module.ModuleManager;
import org.lingBotTeam.lingBot.utils.MessageManager;
import org.lingBotTeam.lingBot.utils.logging.StorageLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class LingBot {
    public static final Logger LOGGER = new StorageLogger("LingBot");
    private final EventManager eventManager = new EventManager();
    private final MessageManager messageManager = new MessageManager();
    private final ModuleManager moduleManager = new ModuleManager(this);
    private static LingBot INSTANCE;
    private final long botQUuid;
    public final ExecutorService POOL = Executors.newCachedThreadPool();
    public final ExecutorService SCHEDULER_SERVICE = Executors.newScheduledThreadPool(10);

    public LingBot(long qId) {
        botQUuid = qId;
        eventManager.callEvent(new BotEnableEvent());
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public Logger getLogger() {
        return LOGGER;
    }

    public static LingBot getInstance() {
        return INSTANCE;
    }

    public Long getBotQNumber() {
        return botQUuid;
    }

    public static void run(long qid) {
        INSTANCE = new LingBot(qid);
    }
}
