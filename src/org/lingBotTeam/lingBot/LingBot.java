package org.lingBotTeam.lingBot;

import org.lingBotTeam.lingBot.event.EventManager;
import org.lingBotTeam.lingBot.utils.MessageManager;

import java.util.logging.Logger;

public class LingBot {
    Logger logger = Logger.getGlobal();
    private final EventManager eventManager = new EventManager();
    private final MessageManager messageManager = new MessageManager();

    private static LingBot INSTANCE;

    public static LingBot getInstance() {
        return INSTANCE;
    }

    public static void run() {
        INSTANCE = new LingBot();
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}
