package ir.maktab.model;

import ir.maktab.enumiration.MonthType;

public class Date {
    private int day;
    private int mon;
    private int year;
    public Date(int day, int mon, int year) {
        this.day = day;
        this.mon = mon;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMon() {
        return mon;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public boolean isValidDate(int year, int mon, int day) {
        boolean check = false;
        if (year <= 9999 && year >= 1 && mon <= 12 && mon >= 1) {
            if (mon >= 1 && mon <= 6) {
                if (day >= 1 && day <= 31) {
                    check = true;
                } else
                    check = false;
            } else if (mon > 6 && mon < 12) {
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
    public String nameMonth() {
        String nameMonth = "";
        switch (mon) {
            case 1:
                nameMonth = MonthType.FARVARDIN.getNameMonth();
                break;
            case 2:
                nameMonth = MonthType.ORDIBEHESHT.getNameMonth();
                break;
            case 3:
                nameMonth = MonthType.khOURDAD.getNameMonth();
                break;
            case 4:
                nameMonth = MonthType.TIR.getNameMonth();
                break;
            case 5:
                nameMonth = MonthType.MORDAD.getNameMonth();
                break;
            case 6:
                nameMonth = MonthType.SHAHRIVAR.getNameMonth();
                break;
            case 7:
                nameMonth = MonthType.MEHR.getNameMonth();
                break;
            case 8:
                nameMonth = MonthType.ABAN.getNameMonth();
                break;
            case 9:
                nameMonth = MonthType.AZAR.getNameMonth();
                break;
            case 10:
                nameMonth = MonthType.DAY.getNameMonth();
                break;
            case 11:
                nameMonth = MonthType.BAHMAN.getNameMonth();
                break;
            case 12:
                nameMonth = MonthType.ESFAND.getNameMonth();
                break;
        }
        return nameMonth;
    }
    @Override
    public String toString() {
        return day + "/"
                + nameMonth() + "/"
                + year;
    }

    public int getMonthLastDay(int mon) {
        if (mon >= 1 && mon <= 6)
            return 31;
        else if (mon > 6 && mon < 12)
            return 30;
        else
            return 29;
    }
    public void nextDay() {
        if (mon >= 1 && mon <= 6) {
            if (day == 31) {
                day = 1;
                mon = mon + 1;
            } else setDay(getDay() + 1);

        } else if (mon > 6 && mon < 12) {
            if (day == 30) {
                day = 1;
                mon = mon + 1;
            } else day = day + 1;
        } else if (mon == 12) {
            if (day == 29) {
                day = 1;
                mon = 1;
                year = year + 1;
            } else day = day + 1;
        }

    }
}
