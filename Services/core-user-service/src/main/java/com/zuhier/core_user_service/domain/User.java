package com.zuhier.core_user_service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="app_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;


    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    // link to login info
    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name",
            insertable = false, updatable = false)
    LoginInfo loginInfo;


    public User() {
    }

    // link to roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Roles> roles=new HashSet<>();

    // link to permission
    @ManyToMany
    @JoinTable(
            name="permission_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="permission_id")
    )
    private Set<Permission> permissions=new HashSet<>();

}
