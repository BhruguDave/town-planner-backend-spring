package com.example.helloworld.repository;

import com.example.helloworld.objects.Building;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<Building, Integer> { }
