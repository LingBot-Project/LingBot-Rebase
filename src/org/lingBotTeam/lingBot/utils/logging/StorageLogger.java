package org.lingBotTeam.lingBot.utils.logging;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

public class StorageLogger extends java.util.logging.Logger {
    private final ConcurrentLinkedQueue<LogRecord> recordQueue = new ConcurrentLinkedQueue<>();
    /**
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     *
     * @param name               A name for the logger.  This should
     *                           be a dot-separated name and should normally
     *                           be based on the package name or class name
     *                           of the subsystem, such as java.net
     *                           or javax.swing.  It may be null for anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none
     *                           of the messages require localization.
     */
    protected StorageLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
        LogManager.getLogManager().addLogger(this);
    }

    public StorageLogger(String name) {
        this(name, null);
    }

    @Override
    public void log(LogRecord record) {
        recordQueue.add(record);
    }

    public void dispatchAll() {
        if (recordQueue.isEmpty()) return;
        while (!recordQueue.isEmpty()) {
            super.log(recordQueue.poll());
        }
    }
}
