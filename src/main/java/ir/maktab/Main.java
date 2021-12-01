package ir.maktab;

import ir.maktab.dao.BorrowDao;
import ir.maktab.date.Date;
import ir.maktab.date.ValidationDateInput;
import ir.maktab.model.Borrow;
import ir.maktab.model.Disc;
import ir.maktab.model.Person;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ValidationDateInput validationDateInput = new ValidationDateInput();
        BorrowDao borrowDao = new BorrowDao();
        System.out.println("Number of events & fine amount");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        String[] eventsAndFine = data.split(" ");
        int events = Integer.parseInt(eventsAndFine[0]);
        long fine = Long.parseLong(eventsAndFine[1]);
        for (int i = 0; i < events; i++) {
            System.out.println("enter date,member name,software name");
            String information = scanner.nextLine();
            String[] userInformation = information.split(" ");
            int day = Integer.parseInt(userInformation[0]);
            int month = Integer.parseInt(userInformation[1]);
            int year = Integer.parseInt(userInformation[2]);
            String memberName = userInformation[3];
            String softwareName = userInformation[4];
            Person person = new Person(memberName);
            Disc disc = new Disc(softwareName);
            Date date = new Date(day, month, year);
            Borrow borrow = new Borrow(disc,date,person);
            borrowDao.save(borrow);


        }














/*        ValidationDateInput validationDateInput = new ValidationDateInput();
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        if (validationDateInput.isValidDate(day, month, year)) {
            Date date = new Date(day, month, year);
            System.out.println(date);
        } else {
            System.out.println("invalid");
        }*/

    }
}
