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
 * This entity uses to maintain advertisement selling product types
 * these types are link with souvenir and main advertisement type
 * Using this product type we can define price and availability counts
 */

@Entity
@Table(name = "PRODUCT_TYPE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class ProductType implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_type_sequence")
    @SequenceGenerator(name = "sub_type_sequence", sequenceName = "SUB_TYPE_SEQ")
    private long id;

    @Getter
    @Setter
    @Column(name = "product_code", nullable = false)
    private String prodCode;

    @Getter
    @Setter
    @Column(name = "product_name", nullable = false)
    private String prodName;

    @Getter
    @Setter
    @Column(name = "description", nullable = false)
    private String description;


    @Getter
    @Setter //@JsonManagedReference(value = "souvenir_product")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "souvenir_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "productTypes"})
    private Souvenir souvenir;

    @Getter
    @Setter  // @JsonManagedReference(value = "adtype_product")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_type_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "productTypes"})
    private AdvertisementType advertisementType;

    @Getter
    @Setter //@JsonManagedReference(value = "sellingUnit_product")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "productTypes"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "selling_unit_id", nullable = false)
    private SellingUnit sellingUnit;

    @Getter
    @Setter
    // @JsonBackReference(value = "product_advertisement")@JsonIgnoreProperties(value = "productType",allowSetters = true)
    @JsonIgnore
    @OneToMany(mappedBy = "productType", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Advertisement> advertisements;
}
