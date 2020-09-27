package com.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * uses to hold advertisement processing stages
 */

@Entity
@Table(name = "AD_STAGE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class AdStage implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "stage_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ad_stage_sequence")
    @SequenceGenerator(name = "ad_stage_sequence", sequenceName = "AD_STAGE_SEQ")
    private long id;

    @Getter
    @Setter
    @Column(name = "stage_code", nullable = false)
    private String categoryCode;

    @Getter
    @Setter
    @Column(name = "stage_name", nullable = false)
    private String categoryName;

    @Getter
    @Setter
    @Column(name = "description", nullable = false)
    private String description;
}

