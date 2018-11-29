package com.cmssc.unite.unite.controller;

import com.cmssc.unite.unite.model.Friend;
import com.cmssc.unite.unite.service.FriendService;
import com.cmssc.unite.unite.util.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/friend")
//@CrossOrigin(origins = {"http://localhost:4200/**", "http://localhost:4200"})
public class FriendController {

    @Autowired
    private FriendService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Friend friend) {
        friend.setPassword(Password.generateHash(friend.getPassword()));
        service.save(friend);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Friend> get(@PathVariable Integer id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
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

    @RequestMapping(value = "/friendId/{cellphone}", method = RequestMethod.GET)
    public ResponseEntity<Integer> findIdByCellphone(@PathVariable String cellphone) {
        return new ResponseEntity(service.findIdByCellphone(cellphone), HttpStatus.OK);
    }

    @RequestMapping(value = "/myfriends/{friendId}", method = RequestMethod.GET)
    public ResponseEntity<Set<Friend>> findByCurrentFriendId(@PathVariable Integer friendId) {
        return new ResponseEntity(service.findFriendsByCurrentFriendId(friendId), HttpStatus.OK);
    }
}
