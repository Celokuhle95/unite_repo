package com.cmssc.unite.unite.service.impl;

import com.cmssc.unite.unite.dao.MessageRepo;
import com.cmssc.unite.unite.model.Message;
import com.cmssc.unite.unite.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo repo;

    @Override
    public void save(Message message) {
        repo.save(message);
    }

    @Override
    public Message get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Message message) {
        repo.delete(message);
    }

    @Override
    public Set<Message> findTop3ByFriendshipId(Integer friendshipId) {
        return repo.findTop3ByFriendshipId(friendshipId);
    }

    @Override
    public Set<Message> findAllAfterCertainMessage(Integer friendshipId, Integer messageId) {
        return this.repo.findAllAfterCertainMessage(friendshipId, messageId);
    }
}
