package com.cmssc.unite.unite.dao;

import com.cmssc.unite.unite.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer> {

}
