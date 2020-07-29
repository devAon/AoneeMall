package com.devAon.aoneemall.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by qwone4@gmail.com on 2020-07-29
 * Blog : https://velog.io/@aonee
 * Github : http://github.com/devAon
 */


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
}
