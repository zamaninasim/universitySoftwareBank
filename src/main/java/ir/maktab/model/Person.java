package ir.maktab.model;

import ir.maktab.date.Date;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int lateDays;
    List<Borrow> borrowed = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    public void borrow(Disc disc, Date date) {
        Borrow borrow = new Borrow(disc, date,this);
        borrowed.add(borrow);
    }

    public void deliver(Disc disc, Date date) {
        Borrow borrow = new Borrow(disc, date,this);
        borrowed.remove(borrow);
    }
}
