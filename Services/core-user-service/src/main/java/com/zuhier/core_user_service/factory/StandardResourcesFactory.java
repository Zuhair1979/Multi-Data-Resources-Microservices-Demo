package com.zuhier.core_user_service.factory;

import com.zuhier.core_user_service.domain.LoginInfo;
import com.zuhier.core_user_service.domain.Permission;
import com.zuhier.core_user_service.domain.Roles;
import com.zuhier.core_user_service.providers.LoginInfoProvider;
import com.zuhier.core_user_service.providers.PermissionProvider;
import com.zuhier.core_user_service.providers.RolesProvider;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StandardResourcesFactory {
    List<LoginInfoProvider> loginInfoFactory();

    List<PermissionProvider> permissionFactory();

    List<RolesProvider> rolesFactory();

    Optional<LoginInfo> resolveLoginInfo(String userName);

    Set<Roles> resolveRoles(String userName);

    Set<Permission> resolvePermission(String userName);
}
