package org.lingBotTeam.lingBot.event.events.botEvent;

import org.lingBotTeam.lingBot.event.Event;

public class BotDisableEvent implements Event {
    public final Long timeStamp;
    public BotDisableEvent() {
        timeStamp = System.currentTimeMillis();
    }
}
