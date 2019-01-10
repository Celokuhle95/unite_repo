package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MessageRepo extends JpaRepository<Message, Integer> {

    @Query("SELECT m FROM Message m WHERE m.friendship.id = :friendshipId AND m.id > :messageId")
    Set<Message> findAllAfterCertainMessage(Integer friendshipId, Integer messageId);

    // @Query("SELECT m FROM MESSAGE m WHERE m.friendship.id = :friendshipId")
    Set<Message> findTop3ByFriendshipId(Integer friendshipId);
}
