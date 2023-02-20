package org.lingBotTeam.lingBot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lingBotTeam.lingBot.utils.qUtils.Group;
import org.lingBotTeam.lingBot.utils.qUtils.User;

import java.util.concurrent.ConcurrentHashMap;

public class MessageManager {
    public final ConcurrentHashMap<Long, Group> groupsMap = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<User, Group> usersMap = new ConcurrentHashMap<>();
    public final Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    public Group MANAGER_GROUP;

    public Group getGroup(long id) {
        return groupsMap.get(id);
    }

    public Group getGroupOrCreateWhenNull(long id) {
        Group group = getGroup(id);
        if (group != null) return group;
        group = new Group(id);
        groupsMap.put(id, group);
        return group;
    }

    public User getUser(long id) {
        return null;
    }


}
