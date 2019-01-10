package com.cmssc.unite.unite.service;

import com.cmssc.unite.unite.model.Message;

import java.util.Set;

public interface MessageService extends BaseService<Message> {

    Set<Message> findTop3ByFriendshipId(Integer friendshipId);

    Set<Message> findAllAfterCertainMessage(Integer friendshipId, Integer messageId);
}
