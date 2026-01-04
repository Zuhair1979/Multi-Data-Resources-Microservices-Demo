package com.zuhier.core_user_service.providers.impl;

import com.zuhier.core_user_service.dao.IRoles;
import com.zuhier.core_user_service.dao.IUser;
import com.zuhier.core_user_service.domain_simulation.Roles;
import com.zuhier.core_user_service.domain_simulation.User;
import com.zuhier.core_user_service.providers.RolesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
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
