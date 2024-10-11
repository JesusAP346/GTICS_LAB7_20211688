package org.example.gtics_lab7_20211688.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @ManyToOne
    @JoinColumn(name="roleId")
    private Roles roleId;


    @Column(name = "name")
    private String name;



}
