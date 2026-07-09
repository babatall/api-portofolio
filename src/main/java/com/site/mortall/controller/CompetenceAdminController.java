package com.site.mortall.controller;

import com.site.mortall.dto.CompetenceDTO;
import com.site.mortall.dto.CompetenceRequest;
import com.site.mortall.service.CompetenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/competences")
@RequiredArgsConstructor
public class CompetenceAdminController {

    private final CompetenceService competenceService;

    @GetMapping("/{id}")
    public CompetenceDTO getCompetence(@PathVariable Long id) {
        return competenceService.getCompetenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetenceDTO createCompetence(@Valid @RequestBody CompetenceRequest request) {
        return competenceService.createCompetence(request);
    }

    @PutMapping("/{id}")
    public CompetenceDTO updateCompetence(@PathVariable Long id, @Valid @RequestBody CompetenceRequest request) {
        return competenceService.updateCompetence(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }
}