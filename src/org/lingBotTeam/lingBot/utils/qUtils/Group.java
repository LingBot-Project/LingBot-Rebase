package org.lingBotTeam.lingBot.utils.qUtils;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Group {
    private final long groupId;
    private final LinkedHashSet<User> users = new LinkedHashSet<>();
    public Group(long id) {
        groupId = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void sendMessage(String str) {
        // TODO: 2023-02-19 1:42
    }

    public boolean haveUser(User user) {
        return users.contains(user);
    }

    public void putUser(User user) {
        users.add(user);
        user.updateAlive();
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getGroupId() == group.getGroupId();
    }
}
