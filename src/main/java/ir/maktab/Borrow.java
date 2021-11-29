package ir.maktab;

public class Borrow {
    private Disc disc;
    private Date date;

    public Borrow(Disc disc, Date date) {
        this.disc = disc;
        this.date = date;
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

    private boolean isLate(Date deliveryDate){
        //TODO
        return false;
    }
}
