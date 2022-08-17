package com.spring.spring.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "post")
public class Post {
    @Id
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)     // bir user silindiğinde postalrı silinsin
    private User user;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "post")
    private List<Begeni> begeni;

    @Column(name = "create_date")
    private Date createDate;
}
