package ir.maktab.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate(int day, int month, int year) {
        boolean check = false;
        if (year <= 9999 && year >= 1 && month <= 12 && month >= 1) {
            if (month >= 1 && month <= 6) {
                if (day >= 1 && day <= 31) {
                    check = true;
                } else
                    check = false;
            } else if (month > 6 && month < 12) {
                if (day >= 1 && day <= 30) {
                    check = true;
                } else check = false;
            } else {
                if (day >= 1 && day <= 29) {
                    check = true;
                } else
                    check = false;
            }
        }
        return check;
    }

    public Long CalculateLateDays(String borrowingDate, String returnDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
        java.util.Date borrowingTime = dateFormat.parse(borrowingDate);
        java.util.Date returnTime = dateFormat.parse(returnDate);
        long difference = returnTime.getTime() - borrowingTime.getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return year +
                "/" + month +
                "/" + day;
    }
}
