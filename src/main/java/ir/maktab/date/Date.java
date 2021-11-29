package ir.maktab.date;

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



  /*  public void nextDay() {
        if (month >= 1 && month <= 6) {
            if (day == 31) {
                day = 1;
                month = month + 1;
            } else setDay(getDay() + 1);

        } else if (month > 6 && month < 12) {
            if (day == 30) {
                day = 1;
                month = month + 1;
            } else day = day + 1;
        } else if (month == 12) {
            if (day == 29) {
                day = 1;
                month = 1;
                year = year + 1;
            } else day = day + 1;
        }

    }*/

    @Override
    public String toString() {
        return year +
                "/" + month +
                "/" + day;
    }
}
