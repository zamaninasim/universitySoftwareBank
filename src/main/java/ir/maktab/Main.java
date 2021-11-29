package ir.maktab;

import ir.maktab.date.Date;
import ir.maktab.date.ValidationDateInput;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ValidationDateInput validationDateInput = new ValidationDateInput();
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        if (validationDateInput.isValidDate(day,month,year)){
            Date date= new Date(day,month,year);
            System.out.println(date);
        }else {
            System.out.println("invalid");
        }

    }
}
