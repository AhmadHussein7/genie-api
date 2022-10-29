package com.technova.genie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technova.genie.models.User;

public interface UserRepository extends  JpaRepository<User, Long>{
	/**
	 * User repository.
	 */
	User findByEmail(String email);
}
