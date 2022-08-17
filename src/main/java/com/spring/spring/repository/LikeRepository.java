package com.spring.spring.repository;

import java.util.List;

import com.spring.spring.entities.Begeni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepository extends JpaRepository<Begeni, Long> {

    List<Begeni> findByUserIdAndPostId(Long userId, Long postId);

    List<Begeni> findByUserId(Long userId);

    List<Begeni> findByPostId(Long postId);

    @Query(value = 	"select 'liked', l.post_id, u.avatar, u.user_name from "
            + "p_like l left join user u on u.id = l.user_id "
            + "where l.post_id in :postIds limit 5", nativeQuery = true)
    List<Object> findUserLikesByPostId(@Param("postIds") List<Long> postIds);
}