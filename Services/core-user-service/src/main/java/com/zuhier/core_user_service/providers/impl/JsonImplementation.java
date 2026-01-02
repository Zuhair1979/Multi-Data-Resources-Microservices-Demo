package com.zuhier.core_user_service.providers.impl;

import com.zuhier.core_user_service.domain.Permission;
import com.zuhier.core_user_service.providers.PermissionProvider;
import com.zuhier.core_user_service.simulation.JsonPermissionSimulation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JsonImplementation implements PermissionProvider {
    private final JsonPermissionSimulation jsonPermissionSimulation;

    public JsonImplementation(JsonPermissionSimulation jsonPermissionSimulation) {
        this.jsonPermissionSimulation=jsonPermissionSimulation;
    }

    @Override
    public Set<Permission> getPermissionInfo(String userName) {
        if(userName ==null || userName.isBlank())
        return Set.of();

        return this.jsonPermissionSimulation.getPermissions(userName).orElse(List.of())
                .stream()
                .map(permission -> new Permission(permission))
                .collect(Collectors.toSet());
    }
}
