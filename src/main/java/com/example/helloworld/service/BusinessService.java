package com.example.helloworld.service;

import com.example.helloworld.objects.Building;
import com.example.helloworld.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    public Iterable<Building> getBuildingData(List<Integer> buildings) {
        return this.businessRepository.findAllById(buildings);
    }
}
