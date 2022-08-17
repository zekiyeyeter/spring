package com.spring.spring.responses;

import com.spring.spring.entities.Begeni;
import com.spring.spring.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String text;
    String title;
    List<Begeni> postBegenis;

    public PostResponse (Post entity, List<Begeni> begenis){
        this.id =entity.getId();
        this.userId = entity.getUser().getId();
        this.userName=entity.getUser().getUserName();
        this.title= entity.getTitle();
        this.text= entity.getText();
        this.postBegenis = begenis;
    }
}
