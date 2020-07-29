package com.devAon.aoneemall.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by qwone4@gmail.com on 2020-07-29
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_QUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
