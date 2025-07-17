package com.springboot.sms.backend.repository;

import com.springboot.sms.backend.entity.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);

	boolean existsByName(String string);
}
