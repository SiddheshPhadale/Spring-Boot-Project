package com.phadale.journal.Controller;

import com.phadale.journal.Entity.journalEntry;
import com.phadale.journal.Entity.user;
import com.phadale.journal.Service.journalService;
import com.phadale.journal.Service.userService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/journal")
public class journalAppController {

    @Autowired
    private journalService service;
    @Autowired
    private userService userService;

    @GetMapping("/{username}")
    public List<journalEntry> getAllByUser(@PathVariable String username){
        user user = userService.getByUsername(username);

        return user.getEntries();
    }

    @PostMapping("/{username}")
    public journalEntry addEntry(@RequestBody journalEntry myEntry, @PathVariable String username){
        service.saveEntry(myEntry, username);
        return myEntry;
    }

    @PutMapping("/edit/{username}/{id}")
    public journalEntry editById(@PathVariable ObjectId id, @RequestBody journalEntry myEntry, @PathVariable String username){
        return service.editById(id, myEntry, username);
    }

    @DeleteMapping("/delete/{username}/{myid}")
    public void deleteById(@PathVariable ObjectId myid, @PathVariable String username){
        service.delete(myid, username);
    }
}
