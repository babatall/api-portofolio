package com.site.mortall.service;

import com.site.mortall.dto.CompetenceDTO;
import com.site.mortall.dto.CompetenceRequest;
import com.site.mortall.entity.Competence;
import com.site.mortall.repository.CompetenceRepository;
import jakarta.persistence.EntityNotFoundException;
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
                .map(this::toDTO)
                .toList();
    }

    public CompetenceDTO getCompetenceById(Long id) {
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compétence introuvable avec l'id : " + id));
        return toDTO(competence);
    }

    public CompetenceDTO createCompetence(CompetenceRequest request) {
        Competence competence = new Competence();
        mapRequestToEntity(request, competence);
        return toDTO(competenceRepository.save(competence));
    }

    public CompetenceDTO updateCompetence(Long id, CompetenceRequest request) {
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compétence introuvable avec l'id : " + id));
        mapRequestToEntity(request, competence);
        return toDTO(competenceRepository.save(competence));
    }

    public void deleteCompetence(Long id) {
        if (!competenceRepository.existsById(id)) {
            throw new EntityNotFoundException("Compétence introuvable avec l'id : " + id);
        }
        competenceRepository.deleteById(id);
    }

    private void mapRequestToEntity(CompetenceRequest request, Competence competence) {
        competence.setNom(request.getNom());
        competence.setCategorie(request.getCategorie());
        competence.setNiveau(request.getNiveau());
        competence.setOrdreAffichage(request.getOrdreAffichage());
    }

    private CompetenceDTO toDTO(Competence c) {
        return new CompetenceDTO(c.getId(), c.getNom(), c.getCategorie(), c.getNiveau());
    }
}