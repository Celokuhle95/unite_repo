package com.cmssc.unite.unite.controller;

import com.cmssc.unite.unite.model.Friend;
import com.cmssc.unite.unite.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Friend friend) {
        service.save(friend);
        return new ResponseEntity<>("Friend Created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Friend> get(@PathVariable Integer id) {
//        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        Friend friend = new Friend();
        friend.setCellphone("55665654");
        friend.setId(11);
        friend.setImage("mx");
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody Friend friend) {
        service.delete(friend);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
