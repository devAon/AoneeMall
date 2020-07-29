package com.devAon.aoneemall.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by qwone4@gmail.com on 2020-07-29
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
