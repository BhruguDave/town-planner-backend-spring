package com.example.helloworld.objects.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "financialjournal")
@NoArgsConstructor
@AllArgsConstructor
public class FinancialJournal {
    @Id
    private Integer id;
    private String participantid;
    private Date timestamp;
    private String category;
    private String amount;
}

// SELECT pg_typeof("id"), pg_typeof("participantid"), pg_typeof("timestamp"),
// pg_typeof("category"), pg_typeof("amount") from financialjournal limit 1;
