package com.zuhier.core_user_service.providers.impl;

import com.zuhier.core_user_service.domain_simulation.LoginInfo;
import com.zuhier.core_user_service.providers.LoginInfoProvider;
import com.zuhier.core_user_service.simulation_data.LDAP;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LdapServiceImplementation implements LoginInfoProvider {


  private final  LDAP ldapInfo;

    public LdapServiceImplementation(LDAP ldapInfo) {
        this.ldapInfo = ldapInfo;
    }

    @Override
    public Optional<LoginInfo> getLoginInfo(String userName) {
        Optional<String> pass;

        if (userName == null || userName.isBlank())
            return Optional.empty();


        return ldapInfo.getPassword(userName).map(password -> new LoginInfo(userName, password));


    }
}
