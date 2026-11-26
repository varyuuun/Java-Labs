package task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class DeshyfruiuchyiReader extends FilterReader {

    private final int kodKliucha;

    public DeshyfruiuchyiReader(Reader in, char kliuch) {
        super(in);
        this.kodKliucha = kliuch;
    }


    @Override
    public int read() throws IOException {
        int symbol = super.read();

        if (symbol == -1) {
            return -1;
        }

        return symbol - kodKliucha;
    }

    @Override
    public int read(char[] cbuf, int off, int len)
            throws IOException {

        int kilkist = super.read(cbuf, off, len);

        if (kilkist == -1) {
            return -1;
        }

        for (int i = off; i < off + kilkist; i++) {
            cbuf[i] = (char) (cbuf[i] - kodKliucha);
        }

        return kilkist;
    }
}
