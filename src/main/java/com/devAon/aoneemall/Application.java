package com.devAon.aoneemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by qwone4@gmail.com on 2020-07-26
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
