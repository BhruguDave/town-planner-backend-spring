package com.example.helloworld.service;

import com.example.helloworld.objects.entity.SocialNetwork;
import com.example.helloworld.repository.SocialNetworkRepository;
import com.example.helloworld.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SocialNetworkService {
    private static Logger logger = LogManager.getLogger(SocialNetworkService.class);
    @Autowired
    private SocialNetworkRepository socialNetworkRepository;
    @Autowired
    private Utils utils;

    public List<SocialNetwork> fetchSocialCirleData(List<String> participants, String date) {
        String formattedString = utils.formatDateString(date, 17);
        Timestamp timestamp = utils.convertStringToTimestamp(formattedString);
        return this.socialNetworkRepository.fetchSocialRelations(participants, timestamp);
    }
}
