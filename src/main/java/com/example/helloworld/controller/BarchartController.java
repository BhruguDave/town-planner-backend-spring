//package com.example.helloworld.controller;
//
//import com.example.helloworld.objects.RequestModel.BarchartRequest;
//import com.example.helloworld.objects.response.BarchartResponse;
//import com.example.helloworld.service.BarchartService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BarchartController {
//    private static Logger logger = LogManager.getLogger(BarchartController.class);
//    @Autowired
//    private BarchartService service;
//
//    @PostMapping("/barchart")
//    public Iterable<BarchartResponse> barchart(@RequestBody BarchartRequest request) {
//        logger.info("Received request on Barchart endpoint");
//        logger.info("Fetching hourly data for VenueId: " + request.getVenueid() + ", Date: " + request.getDate());
//        return service.fetchVenueData(request.getVenueid(), request.getDate());
//    }
//}
