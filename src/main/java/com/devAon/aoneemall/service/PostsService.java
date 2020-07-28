package com.devAon.aoneemall.service;

import com.devAon.aoneemall.domain.posts.Posts;
import com.devAon.aoneemall.domain.posts.PostsRepository;
import com.devAon.aoneemall.web.dto.PostsResponseDto;
import com.devAon.aoneemall.web.dto.PostsSaveRequestDto;
import com.devAon.aoneemall.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qwone4@gmail.com on 2020-07-28
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
