package com.zuhier.core_user_service.dao;

import com.zuhier.core_user_service.domain_simulation.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginInfo extends JpaRepository<LoginInfo,String > {
}
