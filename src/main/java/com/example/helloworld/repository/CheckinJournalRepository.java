package com.example.helloworld.repository;

import com.example.helloworld.objects.CheckinJournal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CheckinJournalRepository extends CrudRepository<CheckinJournal, Integer> {

    @Query(value = "select * from checkinjournal where venueid=?1 and timestamp >= ?2 and timestamp < ?3", nativeQuery = true)
    List<CheckinJournal> fetchHourlyDataForVenueId(String venueid, Timestamp start, Timestamp end);
}
