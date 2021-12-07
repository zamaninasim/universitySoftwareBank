package ir.maktab.model;

import ir.maktab.model.date.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BorrowOperationIsLateTest {
    Borrow borrow;

    @BeforeEach
    void init() {
        borrow = new Borrow(new Disc("Java"), new Date(1400, 10, 6), new Person("nasim"));
    }

    @ParameterizedTest
    @CsvSource({"1400, 10, 10"})
    void givenDeliveryDateLessThanSeven_WhenIsLateCalls_ThenFalseResponseReturn(int year, int month, int day) {
        int days = borrow.calculateBorrowedDays(new Date(year, month, day));
        boolean result = borrow.isLate(days);
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"1400, 10, 20"})
    void givenDeliveryDateMoreThanSeven_WhenIsLateCalls_ThenTrueResponseReturn(int year, int month, int day) {
        int days = borrow.calculateBorrowedDays(new Date(year, month, day));
        boolean result = borrow.isLate(days);
        assertTrue(result);
    }
}
