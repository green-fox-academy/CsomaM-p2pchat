package com.greenfox.csomam.p2pchat.repositories;

import com.greenfox.csomam.p2pchat.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {


}
