package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MessageRepo extends JpaRepository<Message, Integer> {

    // @Query("SELECT m FROM MESSAGE m WHERE m.friendship.id = :friendshipId")
    Set<Message> findTop3ByFriendshipId(Integer friendshipId);
}
