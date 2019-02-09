package com.operationtool.token.oauth.repository;

import org.springframework.data.repository.CrudRepository;

import com.operationtool.token.oauth.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
