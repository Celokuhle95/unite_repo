package com.cmssc.unite.unite.controller;

import com.cmssc.unite.unite.model.Friendship;
import com.cmssc.unite.unite.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    private FriendshipService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Friendship friendship) {
        if (service.findIdByInitiatorIdAndAcceptorId(friendship.getInitiator().getId(), friendship.getAcceptor().getId()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            service.save(friendship);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Friendship> get(@PathVariable Integer id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody Friendship friendship) {
        service.delete(friendship);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getByParticipators/{currentFriendId}/{otherFriendId}", method = RequestMethod.GET)
    public ResponseEntity<Integer> findIdByInitiatorIdAndAcceptorId(@PathVariable Integer currentFriendId, @PathVariable Integer otherFriendId) {
        return new ResponseEntity<>(service.findIdByInitiatorIdAndAcceptorId(currentFriendId, otherFriendId), HttpStatus.OK);
    }

}
