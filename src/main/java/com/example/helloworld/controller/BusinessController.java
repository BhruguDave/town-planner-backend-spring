//package com.example.helloworld.controller;
//
//import com.example.helloworld.service.BusinessService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.helloworld.objects.entity.Building;
//import com.example.helloworld.repository.BusinessRepository;
//import com.example.helloworld.objects.RequestModel.BusinessRequest;
//
//import java.util.Optional;
//import java.util.List;
//
//
//@RestController
//public class BusinessController {
//
//    private static Logger logger = LogManager.getLogger(BusinessController.class);
//    @Autowired
//    private BusinessService service;
//
//    @PostMapping("/business")
//    public Iterable<Building> business(@RequestBody BusinessRequest request) {
//        logger.info("Received request on Business Endpoint");
//        logger.info("Fetching data for BuildingIds: " + request.getBuildings());
//        return service.getBuildingData(request.getBuildings());
//    }
//}
