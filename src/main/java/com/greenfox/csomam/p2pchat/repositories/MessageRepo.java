package com.greenfox.csomam.p2pchat.repositories;

import com.greenfox.csomam.p2pchat.models.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<ChatMessage, Long> {
}
