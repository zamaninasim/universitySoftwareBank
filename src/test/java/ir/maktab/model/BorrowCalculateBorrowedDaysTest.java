package ir.maktab.model;

import ir.maktab.model.date.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BorrowCalculateBorrowedDaysTest {
    Borrow borrow;

    @BeforeEach
    void init() {
        borrow = new Borrow(new Disc("pes"), new Date(1374, 5, 6), new Person("nasim"));
    }

    @ParameterizedTest
    @CsvSource({"1374,5,10, 4", "1374, 5, 20, 14", "1374, 6, 1, 26"})
    void givenDeliveryDate_WhenCalculateBorrowedDaysCalls_ThenResponseReturn(int year, int month, int day, int expect) {
        int result = borrow.calculateBorrowedDays(new Date(year, month, day));
        assertEquals(expect, result);
    }
}
