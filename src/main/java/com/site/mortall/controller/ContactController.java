package com.site.mortall.controller;

import com.site.mortall.dto.MessageContactRequest;
import com.site.mortall.service.MessageContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final MessageContactService messageContactService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void envoyerMessage(@Valid @RequestBody MessageContactRequest request) {
        messageContactService.enregistrerMessage(request);
    }
}