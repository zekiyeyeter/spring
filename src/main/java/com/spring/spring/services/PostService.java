package com.spring.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.spring.spring.entities.Post;
import com.spring.spring.responses.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.spring.spring.entities.User;
import com.spring.spring.repository.PostRepository;
import com.spring.spring.requests.PostCreateRequest;
import com.spring.spring.requests.PostUpdateRequest;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }


    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public PostResponse getOnePostByIdWithLikes(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        return new PostResponse(post, post.getBegeni());
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUserById(newPostRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        toSave.setCreateDate(new Date());
        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

}

//import com.spring.spring.entities.Post;
//import com.spring.spring.entities.User;
//import com.spring.spring.repository.PostRepository;
//
//import com.spring.spring.requests.PostCreateRequest;
//import com.spring.spring.requests.PostUpdateRequest;
//import com.spring.spring.responses.PostResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PostService {
//
//    private PostRepository postRepository;
//    private UserService userService;
//
//    public PostService(PostRepository postRepository,UserService userService) {
//        this.postRepository = postRepository;
//        this.userService=userService;
//
//    }
//
//
//    public List<PostResponse> getAllPosts(Optional<Long> userId) {
//        List<Post> list;
//        if(userId.isPresent()){
//            list= postRepository.findByUserId(userId.get());
//    }
//    list= postRepository.findAll();
//       return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
//
//
//
//    public Post getOnePostById(Long postId) {
//        return postRepository.findById(postId).orElse(null);
//    }
//
//
//    public Post createOnePost(PostCreateRequest newPostRequest) {
//        User user= userService.getOneUserById(newPostRequest.getUserId());
//        if(user==null)
//            return  null;
//        Post existPost= new Post();
//        existPost.setId(newPostRequest.getId());
//        existPost.setText(newPostRequest.getText());
//        existPost.setTitle(newPostRequest.getTitle());
//        existPost.setUser(user);
//
//        return postRepository.save(existPost);
//    }
//
//    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
//     Optional<Post> post =postRepository.findById(postId);
//     if(post.isPresent()){
//         Post toUpdate= post.get();
//         toUpdate.setText((updatePost.getText()));
//         toUpdate.setTitle(updatePost.getTitle());
//         postRepository.save(toUpdate);
//         return toUpdate;
//     }
//     return null;
//    }
//
//    public void deleteOnePostById(Long postId) {
//    }
//}

