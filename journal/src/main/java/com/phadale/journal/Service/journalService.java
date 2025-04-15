package com.phadale.journal.Service;

import com.phadale.journal.Entity.journalEntry;
import com.phadale.journal.Entity.user;
import com.phadale.journal.Repo.repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class journalService {

    @Autowired
    private repository repo;

    @Autowired
    private userService service;

    public void saveEntry(journalEntry entry, String id){
        user user = service.getByUsername(id);
        entry.setDate(LocalDate.now());
        journalEntry saved = repo.save(entry);
        user.getEntries().add(saved);
        service.saveUser(user);
    }

    public List<journalEntry> getAll(){
        return repo.findAll();
    }

    public Optional<journalEntry> getById(ObjectId id){
        return repo.findById(id);
    }

    public void delete(ObjectId id, String username){
        user user = service.getByUsername(username);
        repo.deleteById(id);
        user.getEntries().removeIf(x -> x.getId().equals(id));
        service.saveUser(user);
    }

    public journalEntry editById(ObjectId id , journalEntry myEntry, String username){
        journalEntry old = getById(id).orElse(null);

        if(old != null){
            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : old.getTitle());
            old.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : old.getContent());
        }

        saveEntry(old, username);
        return myEntry;
    }
}
