package org.lingBotTeam.lingBot.utils.string.message;

public class IdMessage extends SimpleMessage {
    protected final long messageId;
    public IdMessage(long id, String message) {
        super(message);
        messageId = id;
    }

    public long getMessageId() {
        return messageId;
    }
}
