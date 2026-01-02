package com.zuhier.core_user_service.providers;

import com.zuhier.core_user_service.domain.LoginInfo;

import java.util.Optional;

public interface LoginInfoProvider {
    // for simulation, loginInfo will get gotten from Map
    Optional<LoginInfo> getLoginInfo(String userName);
}
