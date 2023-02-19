package org.lingBotTeam.lingBot.event.events.groupEvent;

import org.lingBotTeam.lingBot.event.CancellableEvent;
import org.lingBotTeam.lingBot.utils.qUtils.Group;

public class CancellableGroupEvent extends CancellableEvent implements IGroupEvent {
    protected Group group;

    public CancellableGroupEvent(Group group) {
        this.group = group;
    }

    @Override
    public Group getGroup() {
        return group;
    }
}
