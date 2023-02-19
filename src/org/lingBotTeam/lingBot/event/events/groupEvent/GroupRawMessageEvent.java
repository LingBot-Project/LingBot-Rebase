package org.lingBotTeam.lingBot.event.events.groupEvent;

import org.lingBotTeam.lingBot.event.CancellableEvent;
import org.lingBotTeam.lingBot.utils.qUtils.Group;
import org.lingBotTeam.lingBot.utils.qUtils.User;

public class GroupRawMessageEvent extends CancellableGroupEvent {
    private final String message;
    private final User user;
    public GroupRawMessageEvent(Group group, User user, String message) {
        super(group);
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
