package com.cmssc.unite.unite.service;

import com.cmssc.unite.unite.model.Friend;

import java.util.Set;

public interface FriendService extends BaseService<Friend> {

    Integer findIdByCellphone(String cellphone);

    Set<Friend> findFriendsByCurrentFriendId(Integer friendId);

}
