package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface FriendshipRepo extends JpaRepository<Friendship, Integer> {

    @Query("SELECT f.id FROM Friendship f WHERE (f.initiator.id = :currentFriendId AND f.acceptor.id =:otherFriendId) OR (f.initiator.id = :otherFriendId AND f.acceptor.id =:currentFriendId)")
    Integer findIdByInitiatorIdAndAcceptorId(Integer currentFriendId, Integer otherFriendId);

}
