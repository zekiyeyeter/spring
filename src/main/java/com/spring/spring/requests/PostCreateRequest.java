package com.spring.spring.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
    Long id;// insomniadan deneme amaçlı
    String text;
    String title;
    Long UserId;
}
