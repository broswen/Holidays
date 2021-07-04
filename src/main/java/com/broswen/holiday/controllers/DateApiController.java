package com.broswen.holiday.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.broswen.holiday.models.DateResponse;
import com.broswen.holiday.services.DateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DateApiController {

    private final DateService dateService;

    @Autowired
    public DateApiController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/date")
    public DateResponse getProcessingDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate processingDate = this.dateService.getProcessingDate(now);
        return new DateResponse(processingDate);
    }
    
}
