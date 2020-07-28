package com.devAon.aoneemall.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by qwone4@gmail.com on 2020-07-27
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */


public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
