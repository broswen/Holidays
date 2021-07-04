package com.broswen.holiday;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.broswen.holiday.services.DateService;
import com.broswen.holiday.services.DateServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class DateServiceTests {

    private DateService dateService;

    @BeforeAll
    public void setup() {
        this.dateService = new DateServiceImpl(5);
    }

    @Test
    public void ShouldGetSameDate() {
        LocalDateTime datetime = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
        LocalDate want = LocalDate.of(2021, 1, 1);
        LocalDate got = dateService.getProcessingDate(datetime);
        System.out.println(want);
        System.out.println(got);
        assertTrue(got.equals(want));
    }

    @Test
    public void ShouldGetPreviousDate() {
        LocalDateTime datetime = LocalDateTime.of(2021, 1, 2, 4, 59, 59);
        LocalDate want = LocalDate.of(2021, 1, 1);
        LocalDate got = dateService.getProcessingDate(datetime);
        System.out.println(want);
        System.out.println(got);
        assertTrue(got.equals(want));
    }

}
