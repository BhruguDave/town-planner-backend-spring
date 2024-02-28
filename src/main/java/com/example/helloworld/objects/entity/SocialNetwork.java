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
@Table(name = "socialnetwork")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SocialNetwork {
    @Id
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Date timestamp;
    private String participantidfrom;
    private String participantidto;
}

// SELECT pg_typeof("id"), pg_typeof("timestamp"), pg_typeof("participantidfrom"),
// pg_typeof("participantidto") from socialnetwork limit 1;
