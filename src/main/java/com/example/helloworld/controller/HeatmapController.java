package com.example.helloworld.controller;

import com.example.helloworld.objects.HeatmapRequest;
import com.example.helloworld.objects.Log;
import com.example.helloworld.service.HeatmapService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeatmapController {

    private static Logger logger = LogManager.getLogger(HeatmapController.class);
    @Autowired
    private HeatmapService service;

    @PostMapping("/heatmap")
    public List<Log> heatmap(@RequestBody HeatmapRequest request) {
        logger.info("Received request on Heatmap Endpoint");
        logger.info("Fetching date records for Date: " + request.getDate() + ", Hour: " + request.getHour());
        return service.getParticipantLocationData(request.getDate(), request.getHour());
    }
}
