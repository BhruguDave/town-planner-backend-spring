package com.example.helloworld.repository;

import com.example.helloworld.objects.FinancialJournal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository
public interface FinancialJournalRepository extends CrudRepository<FinancialJournal, Integer>{

    @Query(value = "select SUM(CAST( amount AS numeric)) from financialjournal " +
            "where timestamp>=?2 and timestamp<?3 and participantid in ?1", nativeQuery = true)
    Double fetchSpendingByParticipantIds(Set<String> participants, Timestamp start, Timestamp end);
}
