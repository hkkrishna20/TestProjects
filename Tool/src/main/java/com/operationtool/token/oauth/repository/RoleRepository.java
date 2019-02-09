package com.operationtool.token.oauth.repository;

import org.springframework.data.repository.CrudRepository;

import com.operationtool.token.oauth.domain.Role;


interface RoleRepository extends CrudRepository<Role, Long> {
}
