package ir.maktab;

import ir.maktab.dao.BorrowDao;
import ir.maktab.model.date.Date;
import ir.maktab.model.Borrow;
import ir.maktab.model.Disc;
import ir.maktab.model.Person;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        BorrowDao borrowDao = new BorrowDao();
        Borrow borrow = new Borrow();
        Date date = new Date();
        Person person = new Person();
        Map<String, Long> fines = new HashMap<>();

        System.out.println("Number of events & fine amount");
        Scanner scanner = new Scanner(System.in);
        String[] eventsAndFine = scanner.nextLine().split(" ");
        int events = Integer.parseInt(eventsAndFine[0]);
        long fine = Long.parseLong(eventsAndFine[1]);

        for (int i = 0; i < events; i++) {
            System.out.println("enter date,member name,software name");
            String[] borrowInformation = scanner.nextLine().split(" ");
            int year = Integer.parseInt(borrowInformation[0]);
            int month = Integer.parseInt(borrowInformation[1]);
            int day = Integer.parseInt(borrowInformation[2]);
            String memberName = borrowInformation[3];
            String softwareName = borrowInformation[4];

            Person member = new Person(memberName);
            Disc disc = new Disc(softwareName);
            Date inputDate = new Date(year,month,day);
            Borrow borrowSoftware = new Borrow(disc, inputDate, member);

            if (!borrowDao.isMemberBorrowDisc(memberName, softwareName)) {
                borrowDao.save(borrowSoftware);
                member.borrow(borrowSoftware.getDisc(), borrowSoftware.getDate()); //add borrow to list

            } else {
                Borrow returnSoftware = new Borrow(disc, inputDate, member);
                Borrow memberBorrow = borrowDao.findMemberBorrow(memberName, softwareName);
                int borrowDays = memberBorrow.calculateBorrowedDays(returnSoftware.getDate());
                System.out.println("borrow days:" + borrowDays);
                boolean late = memberBorrow.isLate(borrowDays);

                if (late) {
                    long personFines = borrowDays * fine;
                    member.setLateDays(personFines);
                    fines.put(member.getName(), member.getLateDaysFine());
                } else {
                    member.setLateDays(0L);
                    fines.put(member.getName(), member.getLateDaysFine());
                }
                member.deliver(returnSoftware.getDisc(), returnSoftware.getDate());
            }
        }
        System.out.println("for get repots enter 1:");
        int report = scanner.nextInt();
        if (report==1){
            System.out.println("fines:");
            fines.forEach((key, value) -> System.out.println(key + ":" + value));
            System.out.println("borrowed disc:");
            person.getBorrowed().forEach(System.out::println);}
    }
}
