package com.zuhier.core_user_service.providers.impl;

import com.zuhier.core_user_service.dao.IUser;
import com.zuhier.core_user_service.domain_simulation.Permission;
import com.zuhier.core_user_service.domain_simulation.User;
import com.zuhier.core_user_service.providers.PermissionProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
@Order(1)
@Component
public class DbPermissionImplementation implements PermissionProvider {

    private IUser userrep;

    public DbPermissionImplementation(IUser userrep) {
        this.userrep = userrep;
    }


    @Override
    public Set<Permission> getPermissionInfo(String userName) {
        User user=this.userrep.findByUsername(userName);
        // get user permission
        if(user == null )
            return Set.of();

        return user.getPermissions();


    }
}
