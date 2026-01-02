package com.zuhier.core_user_service.providers;

import com.zuhier.core_user_service.domain.Permission;

import java.util.Set;

public interface PermissionProvider {
    Set<Permission> getPermissionInfo(String userName);
}
