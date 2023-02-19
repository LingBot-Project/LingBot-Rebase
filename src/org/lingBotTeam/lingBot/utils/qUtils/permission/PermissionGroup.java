package org.lingBotTeam.lingBot.utils.qUtils.permission;

import java.util.LinkedList;
import java.util.List;

public class PermissionGroup {
    public static final PermissionGroup DEFAULT_GROUP = new PermissionGroup();
    private final LinkedList<Permission> permissions = new LinkedList<>();
    public PermissionGroup() {}

    public void addPermission(Permission... permission) {
        permissions.addAll(List.of(permission));
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }

    public PermissionGroup clone() {
        try {
            return (PermissionGroup) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
