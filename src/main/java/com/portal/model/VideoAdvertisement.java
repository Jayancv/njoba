package com.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.portal.repository.StringPrefixedSequenceIdGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VIDEO_ADVERTISEMENT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class VideoAdvertisement extends Advertisement {

	@Id @Getter @Setter	
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "VDOAD_SEQ")
	@GenericGenerator(
	        name = "VDOAD_SEQ", 
	        strategy = "com.portal.repository.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "VIDAD-"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	@Getter @Setter	@Column(name = "ad_name", nullable = true)
    private String adName = "VIDEO";
}
