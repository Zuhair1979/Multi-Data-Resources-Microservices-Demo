package com.zuhier.core_user_service.providers;

import com.zuhier.core_user_service.domain.Roles;

import java.util.Set;

public interface RolesProvider {
    Set<Roles> getRoles(String userName);
}
