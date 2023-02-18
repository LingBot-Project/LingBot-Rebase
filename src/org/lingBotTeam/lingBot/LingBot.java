package org.lingBotTeam.lingBot;

import java.util.logging.Logger;

public class LingBot {
    Logger logger = Logger.getGlobal();
    private static LingBot INSTANCE;

    public static LingBot getInstance() {
        return INSTANCE;
    }

    public static void run() {
        INSTANCE = new LingBot();
    }
}
