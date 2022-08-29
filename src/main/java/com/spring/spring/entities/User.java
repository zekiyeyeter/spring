package com.spring.spring.entities;

import javax.persistence.*;

import lombok.Data;// geter setter otomotik generate

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String userName;
    String password;
}
