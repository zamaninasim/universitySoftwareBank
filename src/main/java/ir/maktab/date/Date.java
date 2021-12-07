package ir.maktab.date;

import java.util.Objects;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date nextDay() {
        day += 1;
        if (month < 7) {
            if (day - 1 == 31) {
                day = 1;
                month += 1;
            }
        } else if (month == 12) {
            if (day - 1 == 29) {
                day = 1;
                year += 1;
                month = 1;
            }
        } else {
            if (day - 1 == 30) {
                day = 1;
                month += 1;
            }
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    /*public Long calculateDaysBetweenTowDate(String borrowingDate, String returnDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
        java.util.Date borrowingTime = dateFormat.parse(borrowingDate);
        java.util.Date returnTime = dateFormat.parse(returnDate);
        long difference = returnTime.getTime() - borrowingTime.getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }*/


    @Override
    public String toString() {
        return year +
                "/" + month +
                "/" + day;
    }
}
