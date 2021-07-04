package com.broswen.holiday.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.broswen.holiday.models.Holiday;
import com.broswen.holiday.repositories.HolidayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }
    public List<Holiday> getHolidays(LocalDate date) {
        List<Holiday> holidays = new ArrayList<>();
        this.holidayRepository.findAll().forEach(holidays::add);
        holidays.removeIf(h -> !h.getDate().equals(date));
        return holidays;
    }

    public void saveHoliday(Holiday holiday) {
        this.holidayRepository.save(holiday);
    }

    public void deleteHoliday(Holiday holiday) {
        this.holidayRepository.delete(holiday);
    }

    public Holiday findHolidayById(Long id) {
        Optional<Holiday> holiday = this.holidayRepository.findById(id);
        if (holiday.isEmpty()) return null;
        return holiday.get();
    }
}
