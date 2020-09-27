package com.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.portal.model.Team;

public interface TeamService {
	List<Team> getAll();
	Team create(Team obj);
	Team getById(String id);
	Team update(String id, Team obj);
	Team delete(String id, Team obj);
	ResponseEntity<String> hardDelete(String id);
}
