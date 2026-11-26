package task2.model;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nazva;
    private String avtor;
    private String vydavnytstvo;
    private int rik;
    private int storinky;
    private double tsina;

    public Book(String nazva, String avtor, String vydavnytstvo,
                int rik, int storinky, double tsina) {
        this.nazva = nazva;
        this.avtor = avtor;
        this.vydavnytstvo = vydavnytstvo;
        this.rik = rik;
        this.storinky = storinky;
        this.tsina = tsina;
    }

    public String getNazva() {
        return nazva;
    }

    public String getAvtor() {
        return avtor;
    }

    public String getVydavnytstvo() {
        return vydavnytstvo;
    }

    public int getRik() {
        return rik;
    }

    public int getStorinky() {
        return storinky;
    }

    public double getTsina() {
        return tsina;
    }

    @Override
    public String toString() {
        return "Назва: " + nazva
                + ", Автор: " + avtor
                + ", Видавництво: " + vydavnytstvo
                + ", Рік: " + rik
                + ", Сторінок: " + storinky
                + ", Ціна: " + tsina + " грн";
    }
}
