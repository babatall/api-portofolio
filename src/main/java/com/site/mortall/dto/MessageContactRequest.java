package com.site.mortall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageContactRequest {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank
    @Email(message = "Email invalide")
    private String email;

    @NotBlank(message = "Le message ne peut pas être vide")
    private String message;
}