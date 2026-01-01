package com.zuhier.core_user_service.dao;

import com.zuhier.core_user_service.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoles extends JpaRepository<Roles, Integer> {
}
