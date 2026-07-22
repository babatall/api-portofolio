package com.site.mortall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageContactDTO {
    private Long id;
    private String nom;
    private String email;
    private String message;
    private Boolean lu;
    private LocalDateTime dateEnvoi;
}