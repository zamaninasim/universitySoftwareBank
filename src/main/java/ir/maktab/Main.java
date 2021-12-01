package ir.maktab;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
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
            String memberName=userInformation[3];
            String softwareName = userInformation[4];
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
