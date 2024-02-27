package com.example.helloworld.service;

import com.example.helloworld.objects.Log;
import com.example.helloworld.repository.HeatmapRepository;
import com.example.helloworld.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeatmapService {
    private static Logger logger = LogManager.getLogger(HeatmapService.class);
    @Autowired
    private HeatmapRepository heatmapRepository;
    @Autowired
    private Utils utils;
    public List<Log> getParticipantLocationData(String date, Integer hour) {
        logger.info("Fetching participant location data: Date: " + date + ", Hour: " + hour);
        String formattedString = utils.formatDateString(date, hour);
        Timestamp timestamp = utils.convertStringToTimestamp(formattedString);
        return this.heatmapRepository.findAllBytimestamp(timestamp);
    }

    public List<Log> getParticipantActivityData(List<String> participants, String date) {
        logger.info("Fetching participant activity data: Date: " + date + ", ParticipantS: " + participants);
        List<Log> response = new ArrayList<>();
        for(int i=0; i<24; i++) {
            String formattedString = utils.formatDateString(date, i);
            Timestamp timestamp = utils.convertStringToTimestamp(formattedString);
            response.addAll(this.heatmapRepository.fetchActivityData(participants, timestamp));
        }
        return response;
    }
}