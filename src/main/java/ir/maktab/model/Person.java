package ir.maktab.model;

import ir.maktab.model.date.Date;

import java.util.*;

public class Person {
    private String name;
    private Long lateDaysFine;
    static Set<String> borrowedDisc = new HashSet<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Set<String> getBorrowed() {
        return borrowedDisc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLateDaysFine() {
        return lateDaysFine;
    }

    public void setLateDays(Long lateDaysFine) {
        this.lateDaysFine = lateDaysFine;
    }

    public void borrow(Disc disc, Date date) {
        Borrow borrow = new Borrow(disc, date, this);
        borrowedDisc.add(borrow.getDisc().getName());
    }

    public void deliver(Disc disc, Date date) {
        Borrow borrow = new Borrow(disc, date, this);
        borrowedDisc.remove(borrow.getDisc().getName());
    }
}
