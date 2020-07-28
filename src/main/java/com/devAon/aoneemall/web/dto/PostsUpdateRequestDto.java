package com.devAon.aoneemall.web.dto;

import com.devAon.aoneemall.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by qwone4@gmail.com on 2020-07-28
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
