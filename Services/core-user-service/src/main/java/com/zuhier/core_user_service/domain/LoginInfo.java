package com.zuhier.core_user_service.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="login_info")
public class LoginInfo {

    @Id
    @Column(name="user_name")
    private String userName;


    @Column(name="password")
    private String passWord;

    public LoginInfo(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public LoginInfo() {
    }
}
