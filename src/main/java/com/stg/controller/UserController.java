package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Users;
import com.stg.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userlogin", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> userLogin(@RequestParam String userName, @RequestParam String userPassword) {

		Users user = userService.loginUser(userName, userPassword);

		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/createlogin", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> createLogin(@RequestParam Users user) {

		Users users = userService.createUser(user);

		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@PutMapping(value = "/updatelogin", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> updateLogin(@RequestParam Users user) {

		Users users = userService.updateUser(user);

		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletelogin", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> deleteLogin(@RequestParam Users user) {

		userService.deleteUser(user);

		return new ResponseEntity<Users>(HttpStatus.OK);
	}

}
