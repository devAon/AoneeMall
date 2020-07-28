package com.devAon.aoneemall.web.dto;

import com.devAon.aoneemall.domain.posts.Posts;
import lombok.Getter;

/**
 * Created by qwone4@gmail.com on 2020-07-28
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
