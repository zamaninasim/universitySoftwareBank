package ir.maktab.date;

public class ValidationDateInput {
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
}
