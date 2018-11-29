package com.cmssc.unite.unite.service.impl;

import com.cmssc.unite.unite.dao.FriendRepo;
import com.cmssc.unite.unite.model.Friend;
import com.cmssc.unite.unite.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepo repo;

    @Override
    public void save(Friend friend) {
        repo.save(friend);
    }

    @Override
    public Friend get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Friend friend) {
        repo.delete(friend);
    }

    @Override
    public Integer findIdByCellphone(String cellphone) {
        return repo.findIdByCellphone(cellphone);
    }

    @Override
    public Set<Friend> findFriendsByCurrentFriendId(Integer friendId) {
        Set<Friend> acceptedFriends = repo.findAcceptedFriends(friendId);
        Set<Friend> initiatedFriends = repo.findInitiatedFriends(friendId);
        Set<Friend> friends = new HashSet<>(acceptedFriends);
        friends.addAll(initiatedFriends);
        return friends;
    }

}
