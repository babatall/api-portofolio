package com.site.mortall.dto;

import com.site.mortall.entity.CategorieCompetence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDTO {
    private Long id;
    private String nom;
    private CategorieCompetence categorie;
    private Integer niveau;
}