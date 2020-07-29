package com.devAon.aoneemall.web;

import com.devAon.aoneemall.config.auth.dto.SessionUser;
import com.devAon.aoneemall.service.PostsService;
import com.devAon.aoneemall.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Created by qwone4@gmail.com on 2020-07-28
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/") //경로: 머스테치 스타터가 자동 지정해줌
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());

        // 로그인 성공시 SessionUser에 저장
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

