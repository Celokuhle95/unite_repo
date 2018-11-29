package com.cmssc.unite.unite.controller;

import com.cmssc.unite.unite.model.Message;
import com.cmssc.unite.unite.model.dto.MessageDTO;
import com.cmssc.unite.unite.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService service;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Message message) {
        message.setDate(LocalDate.now());
        service.save(message);
        return new ResponseEntity<>("Message Created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<MessageDTO> get(@PathVariable Integer id) {
        Message message = service.get(id);
        MessageDTO dto = new MessageDTO(message.getId(), message.getValue(), message.getDate(), message.getSenderId());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody Message message) {
        service.delete(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/load/{friendshipId}", method = RequestMethod.GET)
    public ResponseEntity<Set<MessageDTO>> findTop3ByFriendshipId(Integer friendshipId) {
        Set<MessageDTO> messageDTOs = service.findTop3ByFriendshipId(friendshipId).stream().map((message) -> {
            return new MessageDTO(message.getId(), message.getValue(), message.getDate(), message.getSenderId());
        }).collect(Collectors.toSet());

        return new ResponseEntity<>(messageDTOs, HttpStatus.OK);
    }

}
