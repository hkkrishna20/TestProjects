package com.operationtool.token.oauth.service;

import java.util.List;

import com.operationtool.token.oauth.domain.User;


public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

}
