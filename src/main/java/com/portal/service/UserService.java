package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.User;

public interface UserService {
	List<User> getAll();
	User create(User obj);
	User getById(String id);
	User update(String id, User obj);
	User delete(String id, User obj);
	ResponseEntity<String> hardDelete(String id);
}
