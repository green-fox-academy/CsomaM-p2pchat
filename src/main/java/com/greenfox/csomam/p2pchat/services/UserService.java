package com.greenfox.csomam.p2pchat.services;

import com.greenfox.csomam.p2pchat.models.User;
import com.greenfox.csomam.p2pchat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Iterable<User> listAll() {
        return userRepo.findAll();
    }

    public User getUser(long id) {
        return userRepo.findOne(id);
    }

    public void addUser (User newUser) {
        userRepo.save(newUser);
    }

    public User getUserByName (String name) {
        return userRepo.findFelhasznalo(name);
    }
}
