package com.devAon.aoneemall.web;

import com.devAon.aoneemall.service.PostsService;
import com.devAon.aoneemall.web.dto.PostsResponseDto;
import com.devAon.aoneemall.web.dto.PostsSaveRequestDto;
import com.devAon.aoneemall.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qwone4@gmail.com on 2020-07-28
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
