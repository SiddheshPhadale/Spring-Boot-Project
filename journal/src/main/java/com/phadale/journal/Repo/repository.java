package com.phadale.journal.Repo;

import com.phadale.journal.Entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface repository extends MongoRepository<journalEntry, ObjectId> {
}
