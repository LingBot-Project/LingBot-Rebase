package org.lingBotTeam.lingBot.event.events.groupEvent;

import org.lingBotTeam.lingBot.event.Event;
import org.lingBotTeam.lingBot.utils.qUtils.Group;

public interface IGroupEvent extends Event {
    public Group getGroup();
}
