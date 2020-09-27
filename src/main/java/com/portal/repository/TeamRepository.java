package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.Team;

public interface TeamRepository extends JpaRepository <Team, String> {

}
