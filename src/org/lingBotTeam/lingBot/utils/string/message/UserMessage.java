package org.lingBotTeam.lingBot.utils.string.message;

import org.lingBotTeam.lingBot.utils.qUtils.User;

public class UserMessage extends IdMessage {
    protected final User user;
    public UserMessage(User user, long id, String message) {
        super(id, message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static UserMessage fromRawMessage(IMessage message) {
        // TODO: 2023-02-20 Complete it
        return null;
    }
}
