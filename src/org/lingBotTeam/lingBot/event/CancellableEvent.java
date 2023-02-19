package org.lingBotTeam.lingBot.event;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancellableEvent implements Event {
    protected boolean cancelled = false;

    public void setCancelled(boolean value) {
        cancelled = value;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancelEvent() {
        setCancelled(true);
    }
}
