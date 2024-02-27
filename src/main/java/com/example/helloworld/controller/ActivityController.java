package com.example.helloworld.controller;

import com.example.helloworld.objects.ActivityRequest;
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
public class ActivityController {
    private static Logger logger = LogManager.getLogger(ActivityController.class);
    @Autowired
    private HeatmapService service;

    @PostMapping("/activity")
    public List<Log> activity(@RequestBody ActivityRequest request) {
        logger.info("Request received on Activity endpoint");
        logger.info("Fetching activity data for Date: " + request.getDate() +
                ", Particpants: " + request.getParticipants());
        return service.getParticipantActivityData(request.getParticipants(), request.getDate());
    }
}
