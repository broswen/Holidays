package com.broswen.holiday.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.broswen.holiday.models.Holiday;
import com.broswen.holiday.services.DateService;
import com.broswen.holiday.services.HolidayService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class HolidayApiController {
    Logger logger = LogManager.getLogger(HolidayApiController.class);

    private final HolidayService holidayService;
    private final DateService dateService;

    @Autowired
    public HolidayApiController(HolidayService holidayService, DateService dateService) {
        this.holidayService = holidayService;
        this.dateService = dateService;
    }

    @GetMapping("/holidays/{year}/{month}/{day}")
    public List<Holiday> getHolidays(@PathVariable(name = "year") int year, @PathVariable(name = "month") int month, @PathVariable(name = "day") int day) {
        LocalDate localDate;
        try {
            localDate = LocalDate.of(year, month, day);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        List<Holiday> holidays = this.holidayService.getHolidays(localDate);
        return holidays;
    }
    
    @GetMapping("/holidays")
    public List<Holiday> getHolidays() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate processingDate = this.dateService.getProcessingDate(now);
        List<Holiday> holidays = this.holidayService.getHolidays(processingDate);
        return holidays;
    }
}
