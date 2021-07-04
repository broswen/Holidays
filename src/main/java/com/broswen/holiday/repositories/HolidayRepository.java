package com.broswen.holiday.repositories;

import com.broswen.holiday.models.Holiday;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Long> {
    
}
