package com.phadale.journal.Controller;

import com.phadale.journal.Entity.user;
import com.phadale.journal.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private userService service;

    @GetMapping
    public List<user> getAllUser(){
        return service.getAll();
    }

    @PostMapping
    public user createUser(@RequestBody user user){
        service.saveUser(user);
        return user;
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody user user, @PathVariable String username){
        user old = service.getByUsername(username);

        if(old != null){
            old.setUserName(user.getUserName());
            old.setPass(user.getPass());
        }

        service.saveUser(old);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
