package com.phadale.journal.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "journalEntries")
@Data
@NoArgsConstructor
public class journalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDate date;
}
