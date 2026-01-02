package com.zuhier.core_user_service.simulation;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Component
public class LDAP {
    private final Map<String, String> ldapInfo;

    public LDAP() {
        ldapInfo=new HashMap<>();
        ldapInfo.put("Zuhier","123");
        ldapInfo.put("Mik","222");
    }
    public Optional<String> getPassword(String password){
      return  Optional.ofNullable(ldapInfo.get(password));
    }


}
