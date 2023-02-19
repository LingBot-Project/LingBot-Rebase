package org.lingBotTeam.lingBot.event.events.botEvent;

import org.lingBotTeam.lingBot.event.Event;

public class BotEnableEvent implements Event {
    public final Long timeStamp;
    public BotEnableEvent() {
        timeStamp = System.currentTimeMillis();
    }
}
