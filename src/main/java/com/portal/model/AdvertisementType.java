package com.portal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Use this to handle Advertisement types {Basic,Banner,Video ...}
 */

@Entity
@Table(name="AD_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class AdvertisementType implements Serializable {

    @Id  @Getter @Setter
    @Column(name = "type_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ad_type_sequence")
    @SequenceGenerator(name = "ad_type_sequence", sequenceName = "AD_TYPE_SEQ")
    private long id;

    @Getter @Setter
    @Column(name = "type_code", nullable = false)
    private String typeCode;

    @Getter @Setter
    @Column(name = "type_name", nullable = false)
    private String typeName;

    @Getter @Setter //@JsonBackReference(value ="adtype_product" ) //@JsonIgnoreProperties(value = "advertisementType",allowSetters = true)
    @OneToMany(mappedBy="advertisementType", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductType> productTypes;

    @Getter @Setter //@JsonBackReference(value = "advertisementType") @JsonIgnoreProperties(value = "advertisementType",allowSetters = true)
    @OneToMany(mappedBy="advertisementType", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Advertisement> advertisements;

}
