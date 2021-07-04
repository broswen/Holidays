package com.broswen.holiday.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DateService {
    public LocalDate getProcessingDate(LocalDateTime datetime);
}
