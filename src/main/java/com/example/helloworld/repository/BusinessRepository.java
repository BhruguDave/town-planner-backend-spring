package com.example.helloworld.repository;

import com.example.helloworld.objects.entity.Building;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<Building, Integer> { }
