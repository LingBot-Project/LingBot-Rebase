package org.lingBotTeam.lingBot.module.impl;

import org.lingBotTeam.lingBot.event.EventHandler;
import org.lingBotTeam.lingBot.event.events.groupEvent.GroupRawMessageEvent;
import org.lingBotTeam.lingBot.module.Module;

public class ModuleHelp extends Module {
    @EventHandler
    public void onGroupMessage(GroupRawMessageEvent event) {
        String message = event.getMessage();
        if ("!help".equals(message)) {
            // do sth.
        }
    }
}
