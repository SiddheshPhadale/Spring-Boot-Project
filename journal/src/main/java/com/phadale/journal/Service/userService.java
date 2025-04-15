package com.phadale.journal.Service;

import com.phadale.journal.Entity.user;
import com.phadale.journal.Repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class userService {

    @Autowired
    private userRepo repo;

    public void saveUser(user user){
        repo.save(user);
    }

    public List<user> getAll(){
        return repo.findAll();
    }

    public user getByUsername(String username){
        return repo.findByuserName(username);
    }
}
