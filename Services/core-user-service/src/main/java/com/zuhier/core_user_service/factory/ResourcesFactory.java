package com.zuhier.core_user_service.factory;

import com.zuhier.core_user_service.domain.LoginInfo;
import com.zuhier.core_user_service.domain.Permission;
import com.zuhier.core_user_service.domain.Roles;
import com.zuhier.core_user_service.providers.LoginInfoProvider;
import com.zuhier.core_user_service.providers.PermissionProvider;
import com.zuhier.core_user_service.providers.RolesProvider;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Getter
public class ResourcesFactory implements StandardResourcesFactory {


    // here we will create the actual provider
    // in future we might change the selection, merging or priority
    /* current criteria is if ldp -> LoginInfoProvider,
    *                         Json -> permissionProvider
    *                         Db   -> RolesProvider
    *                         standard composition  ->
    * Standard execution (current): one provider per data type, no merging.
    *
      Future execution: if the same data type is delivered by multiple sources,
      *  we add a strategy (merge/priority/fallback) in the factory without changing UserService.*/

    private LoginInfoProvider loginInfoProvider;
    private PermissionProvider permissionProvider;
    private RolesProvider rolesProvider;



    public ResourcesFactory(RolesProvider rolesProvider, PermissionProvider permissionProvider, LoginInfoProvider loginInfoProvider) {
        this.rolesProvider = rolesProvider;
        this.permissionProvider = permissionProvider;
        this.loginInfoProvider = loginInfoProvider;
    }


    @Override
    public List<LoginInfoProvider> loginInfoFactory() {
        return List.of(this.loginInfoProvider);
    }

    @Override
    public List<PermissionProvider> permissionFactory() {
        return List.of(this.permissionProvider);
    }

    @Override
    public List<RolesProvider> rolesFactory() {
        return List.of(this.rolesProvider);
    }

    @Override
    public Optional<LoginInfo> resolveLoginInfo(String userName){
        return loginInfoFactory().get(0).getLoginInfo(userName);
    }

    // get and merg all roles from all roles providers, currently we have one provider RolesProvider
    @Override
    public Set<Roles> resolveRoles(String userName){
        // resourceFactory.rolesFactory return list of all roles providers, earch provider has getRole() to return set or Roles
        // result will be after merg all roles one Set<Roles>
        Set<Roles> result=new HashSet<>();
        for(var roles: rolesFactory())

            result.addAll( roles.getRoles(userName));
        return result;

    }

    // get and merg all permissions from all permissions providers, currently we have one permission provider which is json
    @Override
    public Set<Permission> resolvePermission(String userName){
        Set<Permission> result=new HashSet<>();
        for(var permission:permissionFactory())
            result.addAll(permission.getPermissionInfo(userName));
        return result;

    }
}
