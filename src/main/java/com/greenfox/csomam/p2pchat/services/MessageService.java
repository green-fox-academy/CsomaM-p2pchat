package com.greenfox.csomam.p2pchat.services;

import com.greenfox.csomam.p2pchat.P2pchatApplication;
import com.greenfox.csomam.p2pchat.models.Client;
import com.greenfox.csomam.p2pchat.models.Holder;
import com.greenfox.csomam.p2pchat.models.Message;
import com.greenfox.csomam.p2pchat.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public Iterable<Message> listAll() {
        return messageRepo.findAll();
    }

    public Message getMessage(long id) {
        return messageRepo.findOne(id);
    }

    public void addMessage (Message message) {
        messageRepo.save(message);
    }

    public ResponseEntity<Holder> sendMessage(Message message, Client client) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Holder> request = new HttpEntity<>(new Holder(message, client));
        ResponseEntity<Holder> response = restTemplate
                .exchange(P2pchatApplication.CHAT_APP_PEER_ADDRESS, HttpMethod.POST, request, Holder.class);
        return response;
    }
}
