package com.broswen.holiday.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DateServiceImpl implements DateService{
    private int WORKDAYSTART;

    @Autowired
    public DateServiceImpl(@Value("${app.workdatstart:5}") int WORKDAYSTART) {
        this.WORKDAYSTART = WORKDAYSTART;
    }

    public LocalDate getProcessingDate(LocalDateTime datetime) {
        if (datetime.getHour() < this.WORKDAYSTART) {
            return datetime.minusDays(1).toLocalDate();
        }
        return datetime.toLocalDate();
    }
}
