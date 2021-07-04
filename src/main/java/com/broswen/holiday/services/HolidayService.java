package com.broswen.holiday.services;

import java.time.LocalDate;
import java.util.List;

import com.broswen.holiday.models.Holiday;

public interface HolidayService {
    public List<Holiday> getHolidays(LocalDate date);

    public void saveHoliday(Holiday holiday);

    public void deleteHoliday(Holiday holiday);

    public Holiday findHolidayById(Long id);
}
