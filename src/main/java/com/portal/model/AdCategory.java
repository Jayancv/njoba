package com.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Use this to handle advertisement category (IT,Educational,Vehicle... )
 */

@Entity
@Table(name = "AD_CATEGORY")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class AdCategory implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ad_category_sequence")
    @SequenceGenerator(name = "ad_category_sequence", sequenceName = "AD_CAT_SEQ")
    private long id;

    @Getter
    @Setter
    @Column(name = "category_code", nullable = false)
    private String categoryCode;

    @Getter
    @Setter
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Getter
    @Setter
    @Column(name = "description", nullable = false)
    private String description;
}
