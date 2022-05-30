package com.stg.service;

import com.stg.entity.Users;

public interface UserService {

	public abstract Users loginUser(String userName, String userPassword); // validation

	public abstract Users createUser(Users user); // create

	public abstract Users updateUser(Users user); // update

	public abstract void deleteUser(Users user); // delete
}
