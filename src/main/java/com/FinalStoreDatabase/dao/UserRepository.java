package com.FinalStoreDatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FinalStoreDatabase.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
