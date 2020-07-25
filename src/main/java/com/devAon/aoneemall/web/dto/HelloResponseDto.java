package com.devAon.aoneemall.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by qwone4@gmail.com on 2020-07-26
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
