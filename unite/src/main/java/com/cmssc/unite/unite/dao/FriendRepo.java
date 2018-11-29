package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface FriendRepo extends JpaRepository<Friend, Integer> {

    @Query("SELECT f.id FROM Friend f where f.cellphone  = :cellphone")
    Integer findIdByCellphone(String cellphone);

    @Query("SELECT DISTINCT(f.initiator) FROM Friendship f WHERE f.acceptor.id = :friendId")
    Set<Friend> findAcceptedFriends(Integer friendId);

    @Query("SELECT DISTINCT(f.acceptor) FROM Friendship f WHERE f.initiator.id = :friendId")
    Set<Friend> findInitiatedFriends(Integer friendId);


}
