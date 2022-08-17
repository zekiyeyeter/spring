package com.spring.spring.services;

import com.spring.spring.entities.Begeni;
import com.spring.spring.entities.Post;
import com.spring.spring.entities.User;
import com.spring.spring.repository.LikeRepository;
import com.spring.spring.requests.LikeCreateRequest;
import com.spring.spring.responses.LikeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;




@Service
@AllArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;


    public void setLikeService(LikeService likeService){
        this.setLikeService(likeService);
    }

    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Begeni> list;
        if(userId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        }else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    public Begeni getOneLikeById(Long LikeId) {
        return likeRepository.findById(LikeId).orElse(null);
    }

    public Begeni createOneLike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if(user != null && post != null) {
            Begeni begeniToSave = new Begeni();
            begeniToSave.setId(request.getId());
            begeniToSave.setPost(post);
            begeniToSave.setUser(user);
            return likeRepository.save(begeniToSave);
        }else
            return null;
    }

    public void deleteOneLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }


}
