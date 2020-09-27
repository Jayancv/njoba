package com.portal.repository;

import com.portal.model.Souvenir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouvenirRepository extends JpaRepository<Souvenir, Long> {
}
