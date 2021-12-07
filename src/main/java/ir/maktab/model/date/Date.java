package ir.maktab.model.date;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
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


    @Override
    public String toString() {
        return year +
                "/" + month +
                "/" + day;
    }
}
