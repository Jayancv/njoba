package com.portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.portal.repository.StringPrefixedSequenceIdGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AD_USER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class User implements Serializable {

	@Id @Getter @Setter 
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USER_SEQ")
	@GenericGenerator(
	        name = "USER_SEQ", 
	        strategy = "com.portal.repository.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "USR-"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	@Getter @Setter	@Column(name = "user_code", nullable = false)
	private String userCode;

    @Getter @Setter	@Column(name = "first_name", nullable = false)
	private String   firstName;
	@Getter @Setter	@Column(name = "passwd", nullable = false)
	private String passwd; 
	@Getter @Setter	@Column(name = "txt_passwd", nullable = false)
	private String txtPasswd  ;
	@Getter @Setter	@Column(name = "last_Name", nullable = false)
	private String lastName ;
	@Getter @Setter	@Column(name = "email", nullable = false)
	private String email;  
	@Getter @Setter	@Column(name = "last_visit", nullable = true)
	private Date lastVisit;
	@Getter @Setter	@Column(name = "group_id", nullable = true)
	private int groupId ;
	@Getter @Setter	@Column(name = "active", nullable = true)
	private boolean active  ;
	@Getter @Setter	@Column(name = "notified", nullable = true)
	private boolean notified  ;
	@Getter @Setter	@Column(name = "reset_pwd", nullable = true)
	private boolean resetPwd ;
	@Getter @Setter	@Column(name = "nic", nullable = false)
	private String nic  ;
	@Getter @Setter	@Column(name = "oba_id", nullable = false)
	private String obaId  ;
	@Getter @Setter	@Column(name = "old_oba_id", nullable = true)
	private String oldObaId  ;
	@Getter @Setter	@Column(name = "work_group_id", nullable = true)
	private int workGroupId  ;
	@Getter @Setter	@Column(name = "code", nullable = true)
	private String code  ;
	@Getter @Setter	@Column(name = "added_by", nullable = true)
	private String addedBy  ;
	@Getter @Setter	@Column(name = "mobile_1", nullable = false)
	private String mobile1  ;
	@Getter @Setter	@Column(name = "mobile_2", nullable = true)
	private String mobile2  ;
	@Getter @Setter	@Column(name = "office_tel", nullable = true)
	private String officeTel  ;
	@Getter @Setter	@Column(name = "resi_tel", nullable = true)
	private String resiTel  ;
	@Getter @Setter	@Column(name = "fax", nullable = true)
	private String fax  ;
	@Getter @Setter	@Column(name = "address", nullable = false)
	private String address  ;
	@Getter @Setter	@Column(name = "city", nullable = true)
	private String city ; 
	@Getter @Setter	@Column(name = "ad_count", nullable = true)
	private int adCount  ;
	@Getter @Setter	@Column(name = "max_ad_code", nullable = true)
	private int maxAdCode  ;
	@Getter @Setter	@Column(name = "admission_year", nullable = true)
	private int admissionYear  ;

	@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler","teamMember"})
	@Getter @Setter @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_team", nullable = true)
	private Team userTeam;

	@Getter @Setter
	@JsonIgnore
	@OneToMany(mappedBy="teamLeader", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<Team> teamLeads;

	@Getter @Setter
	@JsonIgnore
	@OneToMany(mappedBy="teamCoordinator", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<Team> teamCoordinates;

	@Getter @Setter
	@JsonIgnore
	@OneToMany(mappedBy="userAdvertisement", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Set<Advertisement> advertisement;
	
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