package com.site.mortall.service;

import com.site.mortall.dto.MessageContactRequest;
import com.site.mortall.entity.MessageContact;
import com.site.mortall.repository.MessageContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageContactService {

    private final MessageContactRepository messageContactRepository;

    public void enregistrerMessage(MessageContactRequest request) {
        MessageContact message = new MessageContact();
        message.setNom(request.getNom());
        message.setEmail(request.getEmail());
        message.setMessage(request.getMessage());
        messageContactRepository.save(message);
    }
}