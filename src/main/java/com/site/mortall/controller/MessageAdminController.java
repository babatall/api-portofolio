package com.site.mortall.controller;

import com.site.mortall.dto.MessageContactDTO;
import com.site.mortall.service.MessageContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/messages")
@RequiredArgsConstructor
public class MessageAdminController {

    private final MessageContactService messageContactService;

    @GetMapping
    public List<MessageContactDTO> getAllMessages() {
        return messageContactService.getAllMessages();
    }

    @GetMapping("/non-lus")
    public List<MessageContactDTO> getMessagesNonLus() {
        return messageContactService.getMessagesNonLus();
    }

    @PatchMapping("/{id}/lu")
    public MessageContactDTO marquerCommeLu(@PathVariable Long id) {
        return messageContactService.marquerCommeLu(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable Long id) {
        messageContactService.deleteMessage(id);
    }
}