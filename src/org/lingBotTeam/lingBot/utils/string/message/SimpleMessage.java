package org.lingBotTeam.lingBot.utils.string.message;

public class SimpleMessage implements IMessage {
    protected final String message;
    public SimpleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
