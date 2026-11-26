package task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class ShyfruiuchyiWriter extends FilterWriter {

    private final int kodKliucha;

    public ShyfruiuchyiWriter(Writer out, char kliuch) {
        super(out);
        this.kodKliucha = kliuch;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + kodKliucha);
    }


    @Override
    public void write(char[] cbuf, int off, int len)
            throws IOException {

        if (cbuf == null) {
            throw new NullPointerException();
        }

        if (off < 0 || len < 0 || len > cbuf.length - off) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = off; i < off + len; i++) {
            super.write(cbuf[i] + kodKliucha);
        }
    }

    @Override
    public void write(String str, int off, int len)
            throws IOException {

        if (str == null) {
            throw new NullPointerException();
        }

        if (off < 0 || len < 0 || len > str.length() - off) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = off; i < off + len; i++) {
            super.write(str.charAt(i) + kodKliucha);
        }
    }
}
