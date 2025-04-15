package com.phadale.journal.Repo;

import com.phadale.journal.Entity.user;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<user, ObjectId> {

    user findByuserName(String username);
}
