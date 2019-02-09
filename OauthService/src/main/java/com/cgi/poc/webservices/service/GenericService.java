package com.cgi.poc.webservices.service;

import java.util.List;

import com.cgi.poc.webservices.domain.User;


public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

}
