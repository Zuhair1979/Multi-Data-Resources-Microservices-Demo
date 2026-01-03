package com.zuhier.core_user_service.services;

import com.zuhier.core_user_service.domain.User;
import com.zuhier.core_user_service.factory.StandardResourcesFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    StandardResourcesFactory resourceFactoryImpl;

    public UserService(StandardResourcesFactory resourcesFactory) {
        this.resourceFactoryImpl = resourcesFactory;
    }
    public User aggregateUserInfo(String userName){


   User user=new User();
        user.setLoginInfo(this.resourceFactoryImpl.resolveLoginInfo(userName).orElse(null));
        user.setRoles(this.resourceFactoryImpl.resolveRoles(userName));
        user.setPermissions(this.resourceFactoryImpl.resolvePermission(userName));
return   user;
    }


}
