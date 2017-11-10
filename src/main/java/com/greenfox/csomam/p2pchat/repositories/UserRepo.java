package com.greenfox.csomam.p2pchat.repositories;

import com.greenfox.csomam.p2pchat.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{
}
