package org.lingBotTeam.lingBot.utils.qUtils.permission;

import java.util.LinkedList;

public class PermissionGroup {
    public static final PermissionGroup DEFAULT_GROUP = new PermissionGroup();
    private final LinkedList<Permission> permissions = new LinkedList<>();
    public PermissionGroup() {}

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }
}
