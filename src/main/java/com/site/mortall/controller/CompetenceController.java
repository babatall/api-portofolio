package com.site.mortall.controller;

import com.site.mortall.dto.CompetenceDTO;
import com.site.mortall.service.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competences")
@RequiredArgsConstructor
public class CompetenceController {

    private final CompetenceService competenceService;

    @GetMapping
    public List<CompetenceDTO> getAllCompetences() {
        return competenceService.getAllCompetences();
    }
}