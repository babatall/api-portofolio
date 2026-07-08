package com.site.mortall.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "competences")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    private CategorieCompetence categorie;

    private Integer niveau;

    private Integer ordreAffichage = 0;
}