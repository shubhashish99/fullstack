package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public abstract Users findByUsernameAndUserPassword(String userName, String userPassword);

}
