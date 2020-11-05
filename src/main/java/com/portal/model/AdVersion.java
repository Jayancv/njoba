package com.portal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.portal.repository.StringPrefixedSequenceIdGenerator;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "AD_VERSION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class AdVersion implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADVER_SEQ")
    @GenericGenerator(
            name = "ADVER_SEQ",
            strategy = "com.portal.repository.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AVER-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
    private String version_id;

    @Getter @Setter
    //@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","adVersions"} )
    @JsonBackReference(value = "adVersions")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement", nullable = false)
    private Advertisement advertisement;


    // Use this status to maintain is this adVersion is active, hold or inactive
    @Getter @Setter
    @Column(name = "status", nullable = false)
    private int status;

    @Getter @Setter @Lob
    private Blob image;

    @Getter @Setter
    @Column(name = "content_url", nullable = true)
    private String contentUrl;

    @Getter @Setter
    @Column(name = "content_id", nullable = true)
    private String contentId;

//    @Getter
//    @Setter //@JsonManagedReference(value = "sellingUnit_product")
//    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "contentFile"})
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "content_file_id", nullable = false)
//    private DBFile contentFile;

    @Getter @Setter
    @Column(name = "comment", nullable = true)
    private String comment;

    @Getter  @Setter
    @Column(name = "created_at", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Getter  @Setter
    @Column(name = "updated_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    // Use this to maintain process status of ad version {Not yet edit, Editing complete, waiting for feedback ... }
    @Getter  @Setter
    @Column(name = "status_code", nullable = true)
    private boolean statusCode = true;


}
