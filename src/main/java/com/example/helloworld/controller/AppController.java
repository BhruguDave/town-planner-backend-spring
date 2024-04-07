package com.example.helloworld.controller;

import com.example.helloworld.objects.entity.Building;
import com.example.helloworld.objects.entity.Log;
import com.example.helloworld.objects.entity.SocialNetwork;
import com.example.helloworld.objects.request.*;
import com.example.helloworld.objects.response.BarchartResponse;
import com.example.helloworld.service.BarchartService;
import com.example.helloworld.service.BusinessService;
import com.example.helloworld.service.HeatmapService;
import com.example.helloworld.service.SocialNetworkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppController {

    private static Logger logger = LogManager.getLogger(AppController.class);
    @Autowired
    private HeatmapService heatmapService;
    @Autowired
    private SocialNetworkService socialNetworkService;
    @Autowired
    private BarchartService barchartService;
    @Autowired
    private BusinessService businessService;

    @GetMapping("/health")
    public String index() {
        return "HEALTHY";
    }

    @PostMapping("/heatmap")
    public List<Log> heatmap(@RequestBody HeatmapRequest request) {
        logger.info("Received request on Heatmap Endpoint");
        logger.info("Fetching date records for Date: " + request.getDate() + ", Hour: " + request.getHour());
        return heatmapService.getParticipantLocationData(request.getDate(), request.getHour());
    }

    @PostMapping("/activity")
    public List<Log> activity(@RequestBody ActivityRequest request) {
        logger.info("Request received on Activity endpoint");
        logger.info("Fetching activity data for Date: " + request.getDate() +
                ", Particpants: " + request.getParticipants());
        return heatmapService.getParticipantActivityData(request.getParticipants(), request.getDate());
    }

    @PostMapping("/barchart")
    public Iterable<BarchartResponse> barchart(@RequestBody BarchartRequest request) {
        logger.info("Received request on Barchart endpoint");
        logger.info("Fetching hourly data for VenueId: " + request.getVenueid() + ", Date: " + request.getDate());
        return barchartService.fetchVenueData(request.getVenueid(), request.getDate());
    }

    @PostMapping("/business")
    public Iterable<Building> business(@RequestBody BusinessRequest request) {
        logger.info("Received request on Business Endpoint");
        logger.info("Fetching data for BuildingIds: " + request.getBuildings());
        return businessService.getBuildingData(request.getBuildings());
    }

    @PostMapping("/social_network")
    public List<SocialNetwork> socialNetwork(@RequestBody SocialNetworkRequest request) {
        logger.info("Request received on Social Network Endpoint");
        logger.info("Fetching social network data for Participants: " +
                request.getParticipants() + ", Date: " + request.getDate());
        return socialNetworkService.fetchSocialCirleData(request.getParticipants(), request.getDate());
    }
}
