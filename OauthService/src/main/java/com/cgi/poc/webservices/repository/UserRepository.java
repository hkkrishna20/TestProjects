package com.cgi.poc.webservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.cgi.poc.webservices.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
