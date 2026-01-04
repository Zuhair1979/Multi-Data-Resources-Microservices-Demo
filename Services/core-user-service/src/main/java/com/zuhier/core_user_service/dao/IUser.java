package com.zuhier.core_user_service.dao;

import com.zuhier.core_user_service.domain_simulation.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
