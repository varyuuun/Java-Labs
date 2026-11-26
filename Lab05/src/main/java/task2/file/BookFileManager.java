package task2.file;

import task2.model.BookCatalog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BookFileManager {

    // Збереження каталогу у файл
    public void saveToFile(BookCatalog catalog, String filePath)
            throws IOException {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(filePath))) {

            output.writeObject(catalog);
        }
    }

    // Читання каталогу з файлу
    public BookCatalog readFromFile(String filePath)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(filePath))) {

            Object object = input.readObject();

            if (object instanceof BookCatalog catalog) {
                return catalog;
            }

            throw new IOException("Файл не містить каталогу книг.");
        }
    }
}

