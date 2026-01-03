package com.zuhier.core_user_service.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="permission")
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="permission_id")
    private int permissionId;

    @Column(name="permission_desc")
    private String permission;

    // link to user
    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<User> users=new HashSet<>();

    public Permission(int permissionId, String permission) {
        this.permissionId = permissionId;
        this.permission = permission;
    }

    public Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return this.permission;
    }
}
