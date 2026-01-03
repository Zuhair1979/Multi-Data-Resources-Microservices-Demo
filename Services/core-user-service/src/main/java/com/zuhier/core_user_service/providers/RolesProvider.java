package com.zuhier.core_user_service.providers;

import com.zuhier.core_user_service.domain.Roles;
import org.springframework.stereotype.Component;

import java.util.Set;

public interface RolesProvider {
    Set<Roles> getRoles(String userName);
}
