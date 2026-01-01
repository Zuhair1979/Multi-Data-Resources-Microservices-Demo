package com.zuhier.core_user_service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer role_id ;

    @Column(name="role_desc")
    private String role_desc;

    // link to user in many to many relation
    @ManyToMany(mappedBy = "roles")
    private Set<User> users=new HashSet<>();

       public Roles(Integer role_id, String user_name) {
        this.role_id = role_id;
        this.role_desc = user_name;
    }
}
