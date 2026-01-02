package com.zuhier.core_user_service.providers.impl;

import com.zuhier.core_user_service.dao.IRoles;
import com.zuhier.core_user_service.dao.IUser;
import com.zuhier.core_user_service.domain.Roles;
import com.zuhier.core_user_service.domain.User;
import com.zuhier.core_user_service.providers.RolesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public class DBServiceImplementation implements RolesProvider {

    @Autowired
    IRoles roleRep;
    @Autowired
    IUser userRep;

    @Override
    @Transactional(readOnly = true)
    public Set<Roles> getRoles(String userName) {
     User user=userRep.findByUsername(userName);
     if(user == null )
        return Set.of();

     return user.getRoles();
    }
}
