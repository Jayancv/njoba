package com.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Uses to define advertisement price and selling limits
 */

@Entity
@Table(name="SELLING_UNIT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class SellingUnit implements Serializable {


    @Id  @Getter @Setter
    @Column(name = "unit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sell_unit_sequence")
    @SequenceGenerator(name = "sell_unit_sequence", sequenceName = "SELL_UNIT_SEQ")
    private long unitId;

    @Getter @Setter	@Column(name = "price", nullable = false)
    private double price;

    @Getter @Setter	@Column(name = "cost", nullable = false)
    private double cost;

    @Getter @Setter	@Column(name = "units", nullable = false)
    private int units;

    @Getter @Setter	@Column(name = "remain_count", nullable = false)
    private int remainCount;

    @Getter @Setter	@Column(name = "sold_count", nullable = false)
    private int soldCount;

    @Getter @Setter	@Column(name = "created_at", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Getter @Setter	@Column(name = "updated_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Getter @Setter //@JsonBackReference(value = "sellingUnit_product")
    @OneToMany(mappedBy="sellingUnit", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "sellingUnit",allowSetters = true)
    private Set<ProductType> productTypes;
}
