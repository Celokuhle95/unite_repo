package com.cmssc.unite.unite.service;

import com.cmssc.unite.unite.model.Friendship;

import java.util.Set;

public interface FriendshipService extends BaseService<Friendship> {

    Integer findIdByInitiatorIdAndAcceptorId(Integer currentFriendId, Integer otherFriendId);

}
