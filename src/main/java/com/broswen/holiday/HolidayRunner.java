package com.broswen.holiday;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.broswen.holiday.models.Holiday;
import com.broswen.holiday.services.DateService;
import com.broswen.holiday.services.HolidayService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HolidayRunner implements CommandLineRunner{

    Logger logger = LogManager.getLogger(HolidayRunner.class);

    private final HolidayService holidayService;
    private final DateService dateService;

    @Autowired
    public HolidayRunner(HolidayService holidayService, DateService dateService) {
        this.holidayService = holidayService;
        this.dateService = dateService;
    }

    public void run(String... args) {
        logger.info("Populating Holidays");
        List<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday(LocalDate.of(2021, 1, 1), "NEW YEAR'S DAY"));
        holidays.add(new Holiday(LocalDate.of(2021, 1, 18), "MLK DAY"));
        holidays.add(new Holiday(LocalDate.of(2021, 5, 31), "MEMORIAL DAY"));
        holidays.add(new Holiday(LocalDate.of(2021, 7, 5), "INDEPENDENCE DAY"));
        holidays.add(new Holiday(LocalDate.of(2021, 9, 6), "LABOR DAY"));

        holidays.forEach(this.holidayService::saveHoliday);

        logger.info("Saved " + holidays.size() + " holidays");
        holidays.forEach(h -> logger.info(h.toString()));
    }
    
}
