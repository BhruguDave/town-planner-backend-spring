package com.example.helloworld.repository;

import com.example.helloworld.objects.CheckinJournal;
import com.example.helloworld.objects.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HeatmapRepository extends CrudRepository<Log, Integer>{
    List<Log> findAllBytimestamp(Timestamp timestamp);

    @Query(value = "select * from log where timestamp=?2 and participantid in ?1", nativeQuery = true)
    List<Log> fetchActivityData(List<String> participants, Timestamp timestamp);
}
