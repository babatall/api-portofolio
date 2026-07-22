package com.site.mortall.service;

import com.site.mortall.dto.MessageContactDTO;
import com.site.mortall.dto.MessageContactRequest;
import com.site.mortall.entity.MessageContact;
import com.site.mortall.repository.MessageContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<MessageContactDTO> getAllMessages() {
        return messageContactRepository.findAllByOrderByDateEnvoiDesc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<MessageContactDTO> getMessagesNonLus() {
        return messageContactRepository.findByLuFalseOrderByDateEnvoiDesc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public MessageContactDTO marquerCommeLu(Long id) {
        MessageContact message = messageContactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Message introuvable avec l'id : " + id));
        message.setLu(true);
        return toDTO(messageContactRepository.save(message));
    }

    public void deleteMessage(Long id) {
        if (!messageContactRepository.existsById(id)) {
            throw new EntityNotFoundException("Message introuvable avec l'id : " + id);
        }
        messageContactRepository.deleteById(id);
    }

    private MessageContactDTO toDTO(MessageContact m) {
        return new MessageContactDTO(
                m.getId(), m.getNom(), m.getEmail(),
                m.getMessage(), m.getLu(), m.getDateEnvoi()
        );
    }
}