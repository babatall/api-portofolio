package com.site.mortall.service;

import com.site.mortall.dto.CompetenceDTO;
import com.site.mortall.entity.Competence;
import com.site.mortall.repository.CompetenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public List<CompetenceDTO> getAllCompetences() {
        return competenceRepository.findAllByOrderByOrdreAffichageAsc()
                .stream()
                .map(c -> new CompetenceDTO(c.getId(), c.getNom(), c.getCategorie(), c.getNiveau()))
                .toList();
    }
}