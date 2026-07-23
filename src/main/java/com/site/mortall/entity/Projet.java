package com.site.mortall.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "projets")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(name = "technologie")

    private List<String> technologies = new ArrayList<>();

    private String lienGithub;
    private String lienDemo;
    private String imageUrl;

    private Integer ordreAffichage = 0;

    private Boolean epingle = false;

    @CreationTimestamp
    private LocalDateTime dateCreation;


}
