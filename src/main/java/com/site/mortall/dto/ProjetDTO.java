package com.site.mortall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDTO {
    private Long id;
    private String titre;
    private String description;
    private List<String> technologies;
    private String lienGithub;
    private String lienDemo;
    private String imageUrl;
    private Boolean epingle;
    private Integer ordreAffichage;
}