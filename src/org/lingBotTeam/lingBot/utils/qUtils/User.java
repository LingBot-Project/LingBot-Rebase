package org.lingBotTeam.lingBot.utils.qUtils;

import org.lingBotTeam.lingBot.utils.qUtils.permission.Permission;
import org.lingBotTeam.lingBot.utils.qUtils.permission.PermissionGroup;

import java.util.Objects;

public class User {
    private final long userId;
    private PermissionGroup permissionGroup;
    public User(long id) {
        this(id, PermissionGroup.DEFAULT_GROUP);
    }

    public User(long id, PermissionGroup permissionGroup) {
        this.userId = id;
        this.permissionGroup = permissionGroup;
    }

    public boolean hasPermission(Permission permission) {
        return permissionGroup.hasPermission(permission);
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        if (permissionGroup == null) return;
        this.permissionGroup = permissionGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
