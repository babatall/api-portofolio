package com.site.mortall.service;

import com.site.mortall.dto.ProjetDTO;
import com.site.mortall.dto.ProjetRequest;
import com.site.mortall.entity.Projet;
import com.site.mortall.repository.ProjetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;
    private final FileStorageService fileStorageService;

    public List<ProjetDTO> getAllProjets() {
        return projetRepository.findAllByOrderByOrdreAffichageAsc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ProjetDTO getProjetById(Long id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projet introuvable avec l'id : " + id));
        return toDTO(projet);
    }

    public ProjetDTO createProjet(ProjetRequest request, MultipartFile image) {
        Projet projet = new Projet();
        mapRequestToEntity(request, projet);

        if (image != null && !image.isEmpty()) {
            projet.setImageUrl(fileStorageService.storeFile(image));
        }

        return toDTO(projetRepository.save(projet));
    }

    public ProjetDTO updateProjet(Long id, ProjetRequest request, MultipartFile image) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projet introuvable avec l'id : " + id));

        mapRequestToEntity(request, projet);

        if (image != null && !image.isEmpty()) {
            fileStorageService.deleteFile(projet.getImageUrl());
            projet.setImageUrl(fileStorageService.storeFile(image));
        }

        return toDTO(projetRepository.save(projet));
    }

    public void deleteProjet(Long id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projet introuvable avec l'id : " + id));

        fileStorageService.deleteFile(projet.getImageUrl());
        projetRepository.delete(projet);
    }

    private void mapRequestToEntity(ProjetRequest request, Projet projet) {
        projet.setTitre(request.getTitre());
        projet.setDescription(request.getDescription());
        projet.setTechnologies(request.getTechnologies());
        projet.setLienGithub(request.getLienGithub());
        projet.setLienDemo(request.getLienDemo());
        projet.setEpingle(request.getEpingle());
        projet.setOrdreAffichage(request.getOrdreAffichage());
    }

    private ProjetDTO toDTO(Projet p) {
        return new ProjetDTO(
                p.getId(), p.getTitre(), p.getDescription(),
                p.getTechnologies(), p.getLienGithub(), p.getLienDemo(),
                p.getImageUrl(), p.getEpingle()
        );
    }
}