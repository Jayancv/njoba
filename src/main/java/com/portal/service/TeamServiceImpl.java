package com.portal.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.exception.ResourceNotFoundException;
import com.portal.model.Team;
import com.portal.model.User;
import com.portal.repository.TeamRepository;
import com.portal.repository.UserRepository;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TeamRepository teamRepsitory;

	@Override
	public List<Team> getAll() {
		return teamRepsitory.findAll();
	}

	@Override
	public Team create(Team obj) {
		Set<User> team_member = new HashSet<>();
		for(User user : obj.getTeamMembers()) {
			User dbObject = userRepository.findById(user.getId())
		            .orElseThrow(() -> new ResourceNotFoundException("user", "id", user.getId()));
			team_member.add(dbObject);
		}
		obj.setTeamMembers(team_member);
	    return teamRepsitory.save(obj);
	}

	@Override
	public Team getById(String id) {
	    return teamRepsitory.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public Team update(String id, Team obj) {
		Team dbObject = teamRepsitory.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		dbObject.setTeamName(obj.getTeamName());
		dbObject.setTeamLeader(obj.getTeamLeader());
		dbObject.setTeamCoordinator(obj.getTeamCoordinator());
		Team updatedNode = teamRepsitory.save(dbObject);
	    return updatedNode;
	}

	@Override
	public Team delete(String id, Team obj) {
		Team dbObject = teamRepsitory.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	    dbObject.setStatusCode(false);
	    Team deletedNote = teamRepsitory.save(dbObject);
	    return deletedNote;
	}

	@Override
	public ResponseEntity<String> hardDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
