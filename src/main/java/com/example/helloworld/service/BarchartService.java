package com.example.helloworld.service;

import com.example.helloworld.objects.response.BarchartResponse;
import com.example.helloworld.objects.entity.CheckinJournal;
import com.example.helloworld.repository.CheckinJournalRepository;
import com.example.helloworld.repository.FinancialJournalRepository;
import com.example.helloworld.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BarchartService {
    private static Logger logger = LogManager.getLogger(BarchartService.class);
    @Autowired
    private Utils utils;
    @Autowired
    private CheckinJournalRepository checkinJournalRepository;
    @Autowired
    private FinancialJournalRepository financialJournalRepository;

    public Iterable<BarchartResponse> fetchVenueData(Integer venueid, String date) {
        Set<String> participantsVisited = new HashSet<>();
        List<CheckinJournal> checkinJournalResponse = new ArrayList<>();
        List<BarchartResponse> response = new ArrayList<>();
        for(int i=1; i<25; i++) {
            String formattedString = utils.formatDateString(date, i-1);
            Timestamp startTimestamp = utils.convertStringToTimestamp(formattedString);
            formattedString = utils.formatDateString(date, i);
            Timestamp endTimestamp = utils.convertStringToTimestamp(formattedString);
            checkinJournalResponse = this.checkinJournalRepository.fetchHourlyDataForVenueId(Integer.toString(venueid), startTimestamp, endTimestamp);
            for(CheckinJournal entry: checkinJournalResponse)
                participantsVisited.add(entry.getParticipantid());

            Double totalSpending = fetchSpendingData(participantsVisited, startTimestamp, endTimestamp);
            response.add(new BarchartResponse(participantsVisited, totalSpending == null ? 0.0 : totalSpending));
        }

        return response;
    }

    public Double fetchSpendingData(Set<String> participantid, Timestamp start, Timestamp end) {
        return this.financialJournalRepository.fetchSpendingByParticipantIds(participantid, start, end);
    }
}
