package com.cgi.poc.webservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.cgi.poc.webservices.domain.Role;


interface RoleRepository extends CrudRepository<Role, Long> {
}
