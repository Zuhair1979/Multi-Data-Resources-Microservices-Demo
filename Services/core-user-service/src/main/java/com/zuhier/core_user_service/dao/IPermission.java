package com.zuhier.core_user_service.dao;

import com.zuhier.core_user_service.domain_simulation.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermission extends JpaRepository<Permission,Integer> {
}
