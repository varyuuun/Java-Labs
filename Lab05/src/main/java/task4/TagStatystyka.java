package task4;

import java.io.Serializable;

public class TagStatystyka implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nazvaTegu;
    private int chastota;

    public TagStatystyka(String nazvaTegu, int chastota) {
        this.nazvaTegu = nazvaTegu;
        this.chastota = chastota;
    }

    public String getNazvaTegu() {
        return nazvaTegu;
    }

    public int getChastota() {
        return chastota;
    }

    @Override
    public String toString() {
        return "<" + nazvaTegu + "> — " + chastota;
    }
}
