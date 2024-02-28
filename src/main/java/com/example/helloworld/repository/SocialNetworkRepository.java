package com.example.helloworld.repository;

import com.example.helloworld.objects.entity.SocialNetwork;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface SocialNetworkRepository extends CrudRepository<SocialNetwork, Integer> {

    @Query(value = "select * from socialnetwork where timestamp=?2 and participantidfrom in ?1", nativeQuery = true)
    List<SocialNetwork> fetchSocialRelations(List<String> participants, Timestamp date);
}
