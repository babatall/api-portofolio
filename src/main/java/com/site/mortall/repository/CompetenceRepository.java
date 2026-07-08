package com.site.mortall.repository;

import com.site.mortall.entity.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findAllByOrderByOrdreAffichageAsc();
}