package com.cmssc.unite.unite.controller;

import com.cmssc.unite.unite.model.Message;
import com.cmssc.unite.unite.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private MessageService service;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Message message) {
        service.save(message);
        return new ResponseEntity<>("Message Created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Message> get(@PathVariable Integer id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
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

}
