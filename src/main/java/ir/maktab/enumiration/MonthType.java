package ir.maktab.enumiration;

public enum MonthType {

    FARVARDIN("Farvardin"),

    ORDIBEHESHT("Ordibehesht"),

    khOURDAD("khourdad"),

    TIR("Tir"),

    MORDAD("Mordad"),

    SHAHRIVAR("Shahrivar"),

    MEHR("mehr"),

    ABAN("Aban"),

    AZAR("Azar"),

    DAY("Day"),

    BAHMAN("Bahman"),

    ESFAND("Esfand");

    private String nameMonth;

    MonthType(String nameMonth) {
        this.nameMonth = nameMonth;
    }

    public String getNameMonth() {
        return nameMonth;
    }
}


