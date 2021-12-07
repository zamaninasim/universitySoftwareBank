package ir.maktab.model;

import ir.maktab.date.Date;

public class Borrow {
    private Disc disc;
    private Date date;
    private Person person;

    public Borrow(Disc disc, Date date, Person person) {
        this.disc = disc;
        this.date = date;
        this.person = person;
    }

    public Borrow() {

    }

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public boolean isLate(int borrowDays) {
        return borrowDays > 7;
    }

    public int calculateBorrowedDays(Date deliveryDate) {
        int count = 0;
        while (!date.equals(deliveryDate)) {
            date.nextDay();
            count++;
        }
        return count;
    }


    @Override
    public String toString() {
        return "Borrow{" +
                "disc=" + disc +
                '}';
    }
}
