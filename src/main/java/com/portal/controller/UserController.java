package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.User;
import com.portal.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/user-list")
	public List<User> getAll() {
	    return userServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public User create(@Valid @RequestBody User user) {
	    return userServiceImpl.create(user);
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable(value = "id") String userId) {
	    return userServiceImpl.getById(userId);
	}
	
	@PutMapping("/update-user/{id}")
	public User update(@PathVariable(value = "id") String userId, @Valid @RequestBody User userDetails) {
		return userServiceImpl.update(userId, userDetails);
	}
	
	@PutMapping("/delete-user/{id}")
	public User delete(@PathVariable(value = "id") String userId, @Valid @RequestBody User userDetails) {
		return userServiceImpl.delete(userId, userDetails);
	}

}
