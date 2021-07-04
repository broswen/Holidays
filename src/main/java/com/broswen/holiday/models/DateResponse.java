package com.broswen.holiday.models;

import java.time.LocalDate;

public class DateResponse {

    private LocalDate date;

    public DateResponse(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
