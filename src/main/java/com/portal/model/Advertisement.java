package com.portal.model;

import com.fasterxml.jackson.annotation.*;
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
import java.util.Date;
import java.util.Set;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicAdvertisement.class, name = "BASIC"),
        @JsonSubTypes.Type(value = BannerAdvertisement.class, name = "BANNER"),
        @JsonSubTypes.Type(value = CustomAdvertisement.class, name = "CUSTOM"),
        @JsonSubTypes.Type(value = SectorAdvertisement.class, name = "SECTOR"),
        @JsonSubTypes.Type(value = VideoAdvertisement.class, name = "VIDEO")
})

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ADVERTISEMENT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public abstract class Advertisement implements Serializable {


	@Id @Getter @Setter	
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ADS_SEQ")
	@GenericGenerator(
	        name = "ADS_SEQ", 
	        strategy = "com.portal.repository.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ADS-"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String id;

    @Getter @Setter	@Column(name = "ad_id", nullable = false)
    private long adId  ;

    @Getter @Setter	@Column(name = "ad_code", nullable = false)
    private String adCode;
    
    @Getter @Setter @JsonBackReference @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_advertisement", nullable = true)
	private User userAdvertisement;

    @Getter @Setter	@Column(name = "org_id", nullable = false)
    private long orgId ;

    @Getter @Setter	@Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Getter @Setter	@Column(name = "status", nullable = false)
    private int status;

    @Getter @Setter
    //JsonIgnore
    @JsonManagedReference(value ="adVersions" )
    @OneToMany(mappedBy="advertisement", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<AdVersion> adVersions ;

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

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="souvenir_id", nullable = false) //@JsonManagedReference(value = "souvenirId")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","advertisements"} )
    private Souvenir souvenir;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="advertisement_type_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","advertisements"} )
    private AdvertisementType advertisementType;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_type_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","advertisements"} )
    private ProductType productType;

}
