package com.site.mortall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.mortall.dto.ProjetDTO;
import com.site.mortall.dto.ProjetRequest;
import com.site.mortall.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/admin/projets")
@RequiredArgsConstructor
public class ProjetAdminController {

    private final ProjetService projetService;
    private final ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ProjetDTO getProjet(@PathVariable Long id) {
        return projetService.getProjetById(id);
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetDTO createProjet(
            @RequestPart("projet") String projetJson,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        ProjetRequest request = objectMapper.readValue(projetJson, ProjetRequest.class);
        return projetService.createProjet(request, image);
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ProjetDTO updateProjet(
            @PathVariable Long id,
            @RequestPart("projet") String projetJson,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        ProjetRequest request = objectMapper.readValue(projetJson, ProjetRequest.class);
        return projetService.updateProjet(id, request, image);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
    }
}