package com.spring.spring.controllers;

import com.spring.spring.entities.Post;

import com.spring.spring.responses.PostResponse;
import com.spring.spring.services.PostService;
import com.spring.spring.requests.PostCreateRequest;
import com.spring.spring.requests.PostUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;


    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }


    @GetMapping("/{postId}")
    public PostResponse getOnePost(@PathVariable Long postId) {
        return postService.getOnePostByIdWithLikes(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePostById(postId);
    }
}


// map struct nasil implemente ediliyor ilk ona bak.
// request modeller olustur. yani f.e'den alacakların
// Dtolar olustur. Servisler Dto alıp Dto donmeli.

/*@PostMapping
    public ResponseEntity<PostResponse> createOnePost(@RequestBody PostCreateRequest newPostRequest){
        PostDto postDto = postMapper.postRequestToPostDto(newPostRequest);
        PostDto insertedPostDto =  postService.createOnePost(postDto);
    return ResponseEntity.ok(postMapper.postDtoToPostResponse(insertedPostDto));
}*/



