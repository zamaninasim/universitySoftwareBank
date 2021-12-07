package ir.maktab.model.date;

import ir.maktab.model.date.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateNextDayTest {
    Date date;

    @BeforeEach
    void init() {
        date = new Date();
    }

    @Test
    void givenDay29Of12thMonth_WhenNextDayCalls_ThenReturn1ofFirstMonthNextYear() {
        date.setDay(29);
        date.setMonth(12);
        date.setYear(1390);
        Date result = this.date.nextDay();
        Date expect = new Date(1391, 1, 1);
        assertEquals(expect, result);
    }

    @Test
    void givenDay30From5TheSecondHalfOfTheYear_WhenNextDayCalls_ThenReturnFirstDayOfNextMonthThisYear() {
        date.setDay(30);
        date.setMonth(10);
        date.setYear(1400);
        Date result = this.date.nextDay();
        Date expect = new Date(1400, 11, 1);
        assertEquals(expect, result);
    }

    @Test
    void givenDay31FromTheFirstHalfOfTheYear_WhenNextDayCalls_ThenReturnFirstDayOfNextMonthThisYear() {
        date.setDay(31);
        date.setMonth(6);
        date.setYear(1400);
        Date result = this.date.nextDay();
        Date expect = new Date(1400, 7, 1);
        assertEquals(expect, result);
    }

    @ParameterizedTest
    @CsvSource({"1385, 10, 10, 1385, 10, 11", "1385, 12, 28, 1385, 12, 29", "1399, 2, 30, 1399, 2, 31"})
    void givenDay_WhenDivideCalls_ThenResponseReturn(int year, int month, int day, int expectYear, int expectMonth, int expectDay) {
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        Date result = this.date.nextDay();
        Date expect = new Date(expectYear, expectMonth, expectDay);
        assertEquals(expect, result);
    }
}
