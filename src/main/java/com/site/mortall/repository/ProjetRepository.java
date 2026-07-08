package com.site.mortall.repository;

import com.site.mortall.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findAllByOrderByOrdreAffichageAsc();
    List<Projet> findByEpingleTrueOrderByOrdreAffichageAsc();
}