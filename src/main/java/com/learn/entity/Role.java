package com.learn.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Role {

    ADMIN(new HashSet<>(Arrays.asList(Permissions.WEATHER_READ, Permissions.WEATHER_WRITE, Permissions.WEATHER_DELETE))),
    USER(new HashSet<>(Collections.singletonList(Permissions.WEATHER_READ)));

    private final Set<Permissions> permissions;


    Role(HashSet<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
