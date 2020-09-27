package com.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Uses to hold advertisement sponsors details
 */

@Entity
@Table(name = "ORGANIZATION")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class Organization implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "org_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_sequence")
    @SequenceGenerator(name = "org_sequence", sequenceName = "ORG_SEQ")
    private long id;

    @Getter
    @Setter
    @Column(name = "code", nullable = false)
    private String categoryCode;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String categoryName;

}
