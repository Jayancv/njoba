package com.portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.portal.repository.StringPrefixedSequenceIdGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TEAM")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class Team implements Serializable {
	
	@Id @Getter @Setter	
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TEAM_SEQ")
	@GenericGenerator(
	        name = "TEAM_SEQ", 
	        strategy = "com.portal.repository.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TAM-"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	@Getter @Setter	@Column(name = "team_code", nullable = false)
	private String teamCode;

	@Getter @Setter	@Column(name = "team_name", nullable = false)
	private String   teamName;

	@Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_leader", nullable = true)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "teamLeads"})
	private User teamLeader;

	@Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_coordinator", nullable = true)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "teamCoordinates"})
	private User teamCoordinator;

	@Getter @Setter
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "userTeam"}, allowSetters = true)
	@OneToMany(mappedBy="userTeam", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<User> teamMember;
	
	@Getter @Setter	@Column(name = "created_at", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Getter @Setter	@Column(name = "updated_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @Getter @Setter	@Column(name = "status_code", nullable = true)
    private boolean statusCode = true;
}
