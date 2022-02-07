package com.example.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.exception.UserNotFoundException;
import com.example.model.user.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/test")
	public String getWelcomeNote() {
		return "**Welocome to SpringBoot Application**";
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id) {

		User user = userService.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException(id + " - requested user not found.");
		}
		return userService.getUserById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
		int id = userService.addUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
}
