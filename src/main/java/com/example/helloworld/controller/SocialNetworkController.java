package com.example.helloworld.controller;

import com.example.helloworld.objects.SocialNetwork;
import com.example.helloworld.objects.SocialNetworkRequest;
import com.example.helloworld.service.SocialNetworkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialNetworkController {
    private static Logger logger = LogManager.getLogger(SocialNetworkController.class);

    @Autowired
    private SocialNetworkService service;

    @PostMapping("/social_network")
    public List<SocialNetwork> socialNetwork(@RequestBody SocialNetworkRequest request) {
        logger.info("Request received on Social Network Endpoint");
        logger.info("Fetching social network data for Participants: " +
                request.getParticipants() + ", Date: " + request.getDate());
        return service.fetchSocialCirleData(request.getParticipants(), request.getDate());
    }
}
