package task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TagFileManager {

    public void zberehtyUFail(
            List<TagStatystyka> statystyka,
            String shliakh) throws IOException {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(shliakh))) {

            output.writeObject(new ArrayList<>(statystyka));
        }
    }
}
