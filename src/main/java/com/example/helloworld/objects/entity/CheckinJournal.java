package com.example.helloworld.objects.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "checkinjournal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CheckinJournal {

    @Id
    @JsonIgnore
    Integer id;
    String participantid;
    @JsonIgnore
    Date timestamp;
    @JsonIgnore
    String venueid;
    @JsonIgnore
    String venuetype;
}

// SELECT pg_typeof("id"), pg_typeof("participantid"), pg_typeof("timestamp"),
// pg_typeof("venueid"), pg_typeof("venuetype") from checkinjournal limit 1;
