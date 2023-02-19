package org.lingBotTeam.lingBot.utils.qUtils;

import java.util.Objects;

public class Group {
    private final long groupId;
    public Group(long id) {
        groupId = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void sendMessage(String str) {
        // TODO: 2023-02-19 1:42
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getGroupId() == group.getGroupId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupId());
    }
}
