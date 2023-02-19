package org.lingBotTeam.lingBot.module;

import org.lingBotTeam.lingBot.LingBot;
import org.lingBotTeam.lingBot.module.impl.ModuleHelp;

import java.util.LinkedHashMap;

public class ModuleManager {
    final LingBot instance;
    public LinkedHashMap<Class<? extends Module>, Module> modulesMap = new LinkedHashMap<>();
    public ModuleManager(LingBot lbIn) {
        instance = lbIn;
        registerModules(
                new ModuleHelp()
        );
    }

    public void registerModules(Module... modules) {
        for (Module module : modules) {
            registerModule(module);
        }
    }

    public void registerModule(Module module) {
        modulesMap.put(module.getClass(), module);
        instance.getEventManager().registerListener(module);
    }
}
