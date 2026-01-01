package com.zuhier.core_user_service;

import com.zuhier.core_user_service.dao.ILoginInfo;
import com.zuhier.core_user_service.dao.IPermission;
import com.zuhier.core_user_service.dao.IRoles;
import com.zuhier.core_user_service.dao.IUser;
import com.zuhier.core_user_service.domain.LoginInfo;
import com.zuhier.core_user_service.domain.Permission;
import com.zuhier.core_user_service.domain.Roles;
import com.zuhier.core_user_service.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataSources implements CommandLineRunner {
    @Autowired
    ILoginInfo loginRep;
    @Autowired
    IUser userRep;
    @Autowired
    IRoles rolesRep;

    @Autowired
    IPermission permissionRep;
    // create permission data source
    // user name as key, list of permissions as values
    Map<String, List<String>> userPermission;

    // create userinfo
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        LoginInfo loginInfo=new LoginInfo("zuhier","123");
       // this.loginRep.save(loginInfo);


        //User user=new User();



       User user= this.userRep.findById(1).get();

        user.setLoginInfo(loginInfo);
        //************* test many to many relation user -> roles
        // get one Role from role
        Roles adminRole=this.rolesRep.findById(1).get();
        user.getRoles().add(adminRole);
       // userRep.save(user);

        // create permission
        Permission createPermission=new Permission();
        createPermission.setPermission("Create Folder");
        permissionRep.save(createPermission);

        user.getPermissions().add(createPermission);
        userRep.save(user);

    }
}
