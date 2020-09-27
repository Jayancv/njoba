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
 * Use to maintain souvenirs details
 */

@Entity
@Table(name="SOUVENIR")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class Souvenir  implements Serializable {

    @Id @Getter @Setter
    @Column(name = "souvenir_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "souvenir_sequence")
    @SequenceGenerator(name = "souvenir_sequence", sequenceName = "SOUVENIR_SEQ")
    private long id;

    @Getter @Setter
    @Column(name = "souvenir_code", nullable = false)
    private String souvenirCode;

    @Getter @Setter
    @Column(name = "souvenir_name", nullable = false)
    private String souvenirName;

    @Getter @Setter
    @Column(name = "description", nullable = true)
    private String description;

    @Getter @Setter
    @Column(name = "year", nullable = false)
    private Integer year;

    @Getter @Setter
    @Column(name = "active", nullable = false)
    private boolean active;

    @Getter @Setter
    @Column(name = "visibility", nullable = false)
    private boolean visible;

    @Getter @Setter//@JsonBackReference(value = "souvenirId")// @JsonIgnoreProperties(value = "souvenirId",allowSetters = true)
    @JsonIgnore
    @OneToMany(mappedBy="souvenir", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<ProductType> productTypes;

    @Getter @Setter   //@JsonBackReference(value = "souvenirId")// @JsonIgnoreProperties(value = "souvenirId",allowSetters = true)
    @JsonIgnore
    @OneToMany(mappedBy="souvenir", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Advertisement> advertisements;
}
