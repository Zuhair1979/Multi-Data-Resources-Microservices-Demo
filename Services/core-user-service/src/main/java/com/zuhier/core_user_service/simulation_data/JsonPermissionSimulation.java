package com.zuhier.core_user_service.simulation_data;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Component
public class JsonPermissionSimulation {

    private final Map<String, List<String>> permission;

    public JsonPermissionSimulation() {
        this.permission = new HashMap<>();
        this.permission.put("Zuhier",List.of("create","delete","view"));
        this.permission.put("Mik",List.of("create","delete"));

    }
    public Optional<List<String>> getPermissions(String username){

        return Optional.ofNullable(this.permission.get(username));
    }
 }
