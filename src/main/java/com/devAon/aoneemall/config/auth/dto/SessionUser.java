package com.devAon.aoneemall.config.auth.dto;

import com.devAon.aoneemall.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by qwone4@gmail.com on 2020-07-29
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
