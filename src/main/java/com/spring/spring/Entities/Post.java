package com.spring.spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name= "post")
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)     // bir user silindiğinde postalrı silinsin
    @JsonIgnore
    User user;



    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
