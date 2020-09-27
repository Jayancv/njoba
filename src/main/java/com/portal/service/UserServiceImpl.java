package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.User;
import com.portal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User obj) {
		return userRepository.save(obj);
	}

	@Override
	public User getById(String id) {
		return userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public User update(String id, User obj) {
		 User user = userRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		    user.setFirstName(obj.getFirstName());
		    user.setLastName(obj.getLastName());
		    user.setUserTeam(obj.getUserTeam());
		    User updatedNode = userRepository.save(user);
		    return updatedNode;
	}

	@Override
	public User delete(String id, User obj) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	    user.setStatusCode(false);
	    User deletedNote = userRepository.save(user);
	    return deletedNote;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
