package org.lingBotTeam.lingBot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lingBotTeam.lingBot.utils.qUtils.Group;

import java.util.concurrent.ConcurrentHashMap;

public class MessageManager {
    public final ConcurrentHashMap<Long, Group> groupsMap = new ConcurrentHashMap<>();
    public final Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    public Group MANAGER_GROUP;

    public Group getGroup(long id) {
        return groupsMap.get(id);
    }

    public Group getGroupAutoCreateWhenNull(long id) {
        Group group = getGroup(id);
        if (group != null) return group;
        group = new Group(id);
        groupsMap.put(id, group);
        return group;
    }
}
