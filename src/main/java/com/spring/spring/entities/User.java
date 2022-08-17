package com.spring.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;// geter setter otomotik generate

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    Long id;
    String userName;
    String password;
}
