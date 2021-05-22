package com.mafei.photoapp.api.user.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ap_user")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
