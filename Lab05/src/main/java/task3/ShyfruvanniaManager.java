package task3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShyfruvanniaManager {

    public void zashyfruvaty(
            String vhidnyiFail,
            String vyhidnyiFail,
            char kliuch) throws IOException {

        try (Reader reader = Files.newBufferedReader(
                Path.of(vhidnyiFail), StandardCharsets.UTF_8);

             ShyfruiuchyiWriter writer = new ShyfruiuchyiWriter(
                     Files.newBufferedWriter(
                             Path.of(vyhidnyiFail),
                             StandardCharsets.UTF_8),
                     kliuch)) {

            char[] buffer = new char[1024];
            int kilkist;

            while ((kilkist = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, kilkist);
            }
        }
    }

    public void deshyfruvaty(
            String vhidnyiFail,
            String vyhidnyiFail,
            char kliuch) throws IOException {

        try (DeshyfruiuchyiReader reader = new DeshyfruiuchyiReader(
                Files.newBufferedReader(
                        Path.of(vhidnyiFail),
                        StandardCharsets.UTF_8),
                kliuch);

             BufferedWriter writer = Files.newBufferedWriter(
                     Path.of(vyhidnyiFail),
                     StandardCharsets.UTF_8)) {

            char[] buffer = new char[1024];
            int kilkist;

            while ((kilkist = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, kilkist);
            }
        }
    }
}
