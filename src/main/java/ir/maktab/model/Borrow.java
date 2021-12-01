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

    private boolean isLate(Date deliveryDate){
        //TODO
        return false;
    }
}
