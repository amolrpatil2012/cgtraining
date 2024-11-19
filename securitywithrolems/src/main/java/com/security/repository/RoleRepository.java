package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
