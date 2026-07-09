package com.site.mortall.dto;

import com.site.mortall.entity.CategorieCompetence;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceRequest {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotNull(message = "La catégorie est obligatoire")
    private CategorieCompetence categorie;

    @NotNull
    @Min(value = 1, message = "Le niveau doit être entre 1 et 5")
    @Max(value = 5, message = "Le niveau doit être entre 1 et 5")
    private Integer niveau;

    private Integer ordreAffichage;
}