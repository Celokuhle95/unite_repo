package com.cmssc.unite.unite.service.impl;

import com.cmssc.unite.unite.dao.FriendshipRepo;
import com.cmssc.unite.unite.model.Friendship;
import com.cmssc.unite.unite.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipRepo repo;

    @Override
    public void save(Friendship friendship) {
        repo.save(friendship);
    }

    @Override
    public Friendship get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Friendship friendship) {
        repo.delete(friendship);
    }

    @Override
    public Integer findIdByInitiatorIdAndAcceptorId(Integer currentFriendId, Integer otherFriendId) {
        return repo.findIdByInitiatorIdAndAcceptorId(currentFriendId, otherFriendId);
    }

}
