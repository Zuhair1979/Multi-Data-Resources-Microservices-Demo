package com.zuhier.core_user_service.controller;

import com.zuhier.core_user_service.domain.User;
import com.zuhier.core_user_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) {

        User user = userService.aggregateUserInfo(userName);

        // If you want: return 404 when user is empty (optional)
        // if (user.getLoginInfo() == null && user.getRoles().isEmpty() && user.getPermissions().isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }

        return ResponseEntity.ok(user);
    }
}

