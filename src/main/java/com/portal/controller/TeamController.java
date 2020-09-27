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

import com.portal.model.Team;
import com.portal.service.TeamServiceImpl;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamServiceImpl teamServiceImpl;

	@GetMapping("/team-list")
	public List<Team> getAll() {
	    return teamServiceImpl.getAll();
	}
	
	@PostMapping("/create")
	public Team create(@Valid @RequestBody Team team) {
	    return teamServiceImpl.create(team);
	}
	
	@GetMapping("/{id}")
	public Team getById(@PathVariable(value = "id") String id) {
	    return teamServiceImpl.getById(id);
	}
	
	@PutMapping("/update-team/{id}")
	public Team update(@PathVariable(value = "id") String id, @Valid @RequestBody Team team) {
	    return teamServiceImpl.update(id, team);
	}
	
	@PutMapping("/delete-team/{id}")
	public Team delete(@PathVariable(value = "id") String id, @Valid @RequestBody Team team) {
	    return teamServiceImpl.delete(id, team);
	}
}
