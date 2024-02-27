package com.example.helloworld.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Log {
    @Id
    @JsonIgnore
    private Integer id;
    @Column(columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private Date timestamp;
    private String currentlocation;
    private String participantid;
    private String currentmode;
    @JsonIgnore
    private String hungerstatus;
    @JsonIgnore
    private String sleepstatus;
    @JsonIgnore
    private String apartmentid;
    private String availablebalance;
    @JsonIgnore
    private String jobid;
    @JsonIgnore
    private String financialstatus;
    @JsonIgnore
    private String dailyfoodbudget;
    @JsonIgnore
    private String weeklyextrabudget;
}

// SELECT pg_typeof("id"), pg_typeof("timestamp"), pg_typeof("currentlocation"),
// pg_typeof("participantid"), pg_typeof("currentmode"), pg_typeof("hungerstatus"),
// pg_typeof("sleepstatus"), pg_typeof("apartmentid"), pg_typeof("availablebalance"),
// pg_typeof("jobid"),pg_typeof("financialstatus"), pg_typeof("dailyfoodbudget"),
// pg_typeof("weeklyextrabudget") from logapril2022 limit 1;

/* CREATE TABLE logtemp (
    id int,
    timestamp TIMESTAMP WITH TIME ZONE,
    currentlocation varchar,
    participantid varchar,
    currentmode varchar,
    hungerstatus varchar,
    sleepstatus varchar,
    apartmentid varchar,
    availablebalance varchar,
    jobid varchar,
    financialstatus varchar,
    dailyfoodbudget varchar,
    weeklyextrabudget varchar
);

INSERT INTO logtemp
SELECT *
FROM logmarch2022

*/