package com.stg.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Users;
import com.stg.exception.UserException;
import com.stg.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Users loginUser(String userName, String userPassword) {

		Users users = userRepository.findByUsernameAndUserPassword(userName, userPassword);

		if (users == null) {
			throw new UserException("Invalid User credentials");
		} else {
			return users;
		}
	}

	@Override
	public Users createUser(Users user) {

		return userRepository.save(user);
	}

	@Override
	public Users updateUser(Users user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Users user) {
		userRepository.delete(user);
	}

}
