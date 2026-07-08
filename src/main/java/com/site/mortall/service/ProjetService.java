package com.site.mortall.service;

import com.site.mortall.dto.ProjetDTO;
import com.site.mortall.entity.Projet;
import com.site.mortall.repository.ProjetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;

    public List<ProjetDTO> getAllProjets() {
        return projetRepository.findAllByOrderByOrdreAffichageAsc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private ProjetDTO toDTO(Projet p) {
        return new ProjetDTO(
                p.getId(), p.getTitre(), p.getDescription(),
                p.getTechnologies(), p.getLienGithub(), p.getLienDemo(),
                p.getImageUrl(), p.getEpingle()
        );
    }
}