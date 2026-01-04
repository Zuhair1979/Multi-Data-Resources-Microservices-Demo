package com.zuhier.core_user_service;

import com.zuhier.core_user_service.dao.ILoginInfo;
import com.zuhier.core_user_service.dao.IPermission;
import com.zuhier.core_user_service.dao.IRoles;
import com.zuhier.core_user_service.dao.IUser;
import com.zuhier.core_user_service.domain_simulation.User;
import com.zuhier.core_user_service.services.UserService;
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


    private final UserService userService;

    public DataSources(UserService userService) {
        this.userService = userService;
    }
    // create userinfo
    @Override
    @Transactional
    public void run(String... args) throws Exception {


        System.out.println("DB RolesProvider called for: " );
        User user1 = userRep.findByUsername("Zuhier");
        System.out.println("User from DB is null? " + (user1 == null));
        if (user1 != null) System.out.println("DB roles size=" + user1.getRoles().size());

        User user = userService.aggregateUserInfo("Zuhier");

        System.out.println("===== AGGREGATED USER =====");
        System.out.println("Login: " + user.getLoginInfo());
        System.out.println("Roles: " + user.getRoles());
        System.out.println("Permissions: " + user.getPermissions());
/* user testing
        LoginInfo loginInfo=new LoginInfo("zuhier","123");
        this.loginRep.save(loginInfo);
        //#User user=new User();
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
     //   permissionRep.save(createPermission);

        user.getPermissions().add(createPermission);
     //   userRep.save(user);
*/



    }
}
