package com.spring.spring.controllers;

import com.spring.spring.entities.Begeni;
import com.spring.spring.entities.Comment;
import com.spring.spring.entities.Post;
import com.spring.spring.requests.CommentCreateRequest;
import com.spring.spring.requests.CommentUpdateRequest;
import com.spring.spring.requests.LikeCreateRequest;
import com.spring.spring.requests.PostCreateRequest;
import com.spring.spring.responses.CommentResponse;
import com.spring.spring.responses.LikeResponse;
import com.spring.spring.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/likes")
@AllArgsConstructor


public class LikeController {
    LikeService likeService;

    @PostMapping
    public Begeni createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOneLike(request);
    }

    @GetMapping("/{likeId}")
    public Begeni getOneLikeById(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }


    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId,
                                          @RequestParam Optional<Long> postId) {
        return likeService.getAllLikesWithParam(userId, postId);
    }

    @DeleteMapping
    public void deleteOneLikeById(@PathVariable Long likeId) {
        likeService.deleteOneLikeById(likeId);
    }
}

