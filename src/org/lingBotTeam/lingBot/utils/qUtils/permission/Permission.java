package org.lingBotTeam.lingBot.utils.qUtils.permission;

import java.util.Objects;

public class Permission {
    private final String permissionText;
    public Permission(String permissionText) {
        this.permissionText = permissionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;
        Permission that = (Permission) o;
        return Objects.equals(permissionText, that.permissionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionText);
    }
}
