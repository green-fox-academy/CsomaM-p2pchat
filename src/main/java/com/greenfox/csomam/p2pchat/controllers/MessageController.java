package com.greenfox.csomam.p2pchat.controllers;

import com.greenfox.csomam.p2pchat.models.Holder;
import com.greenfox.csomam.p2pchat.models.Status;
import com.greenfox.csomam.p2pchat.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageRepo messageRepo;

    @PostMapping("/api/message/receive")
    @CrossOrigin("*")
    public ResponseEntity receiveMessage(@RequestBody Holder holder) {
        if (holder.getMessage().getTimestamp()==null||holder.getMessage().getText()==null||holder.getMessage().getUsername()==null) {
            return new ResponseEntity(new Status("error", "Missing field(s)"), HttpStatus.UNAUTHORIZED);
        } else {
            messageRepo.save(holder.getMessage());
            return new ResponseEntity(new Status("ok"), HttpStatus.OK);
        }
    }
}
