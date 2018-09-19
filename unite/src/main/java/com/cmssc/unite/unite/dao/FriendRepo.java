package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface FriendRepo extends JpaRepository<Friend,Integer> {

}
