package task2.app;

import task2.file.BookFileManager;
import task2.model.Book;
import task2.model.BookCatalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KnyzhkovyiDodatok {

    private Scanner scanner;

    public KnyzhkovyiDodatok(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        BookCatalog catalog = new BookCatalog();
        BookFileManager fileManager = new BookFileManager();

        boolean pratsiuie = true;

        while (pratsiuie) {
            System.out.println("\n========== КАТАЛОГ КНИГ ==========");
            System.out.println("1. Показати всі книги");
            System.out.println("2. Пошук за автором");
            System.out.println("3. Пошук за видавництвом");
            System.out.println("4. Пошук книг після певного року");
            System.out.println("5. Сортування за видавництвом");
            System.out.println("6. Зберегти каталог у файл");
            System.out.println("7. Завантажити каталог із файлу");
            System.out.println("0. Вихід");

            int vybir = readInt("Ваш вибір: ");

            switch (vybir) {
                case 1:
                    pokazatyKnyhy(catalog.getBooks());
                    break;

                case 2:
                    poshukZaAvtorom(catalog);
                    break;

                case 3:
                    poshukZaVydavnytstvom(catalog);
                    break;

                case 4:
                    poshukZaRokom(catalog);
                    break;

                case 5:
                    sortuvatyZaVydavnytstvom(catalog);
                    break;

                case 6:
                    System.out.print("Введіть шлях та назву файлу: ");
                    String shliakhZberezhennia = scanner.nextLine().trim();

                    if (!shliakhZberezhennia.isEmpty()) {
                        try {
                            fileManager.saveToFile(
                                    catalog, shliakhZberezhennia
                            );
                            System.out.println("Каталог успішно збережено.");
                        } catch (IOException e) {
                            System.out.println(
                                    "Помилка збереження: " + e.getMessage()
                            );
                        }
                    } else {
                        System.out.println("Шлях до файлу не може бути порожнім.");
                    }
                    break;

                case 7:
                    System.out.print("Введіть шлях до файлу: ");
                    String shliakhZavantazhennia = scanner.nextLine().trim();

                    if (!shliakhZavantazhennia.isEmpty()) {
                        try {
                            catalog = fileManager.readFromFile(
                                    shliakhZavantazhennia
                            );
                            System.out.println("Каталог успішно завантажено.");
                            pokazatyKnyhy(catalog.getBooks());
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(
                                    "Помилка читання файлу: " + e.getMessage()
                            );
                        }
                    } else {
                        System.out.println("Шлях до файлу не може бути порожнім.");
                    }
                    break;

                case 0:
                    System.out.println("Роботу каталогу завершено.");
                    pratsiuie = false;
                    break;

                default:
                    System.out.println("Невірний пункт меню.");
            }
        }
    }

    private void poshukZaAvtorom(BookCatalog catalog) {
        System.out.print("Введіть ім'я автора: ");
        String avtor = scanner.nextLine().trim();

        List<Book> rezultat = new ArrayList<>();

        for (Book book : catalog.getBooks()) {
            if (book.getAvtor().equalsIgnoreCase(avtor)) {
                rezultat.add(book);
            }
        }

        pokazatyKnyhy(rezultat);
    }

    private void poshukZaVydavnytstvom(BookCatalog catalog) {
        System.out.print("Введіть назву видавництва: ");
        String vydavnytstvo = scanner.nextLine().trim();

        List<Book> rezultat = new ArrayList<>();

        for (Book book : catalog.getBooks()) {
            if (book.getVydavnytstvo().equalsIgnoreCase(vydavnytstvo)) {
                rezultat.add(book);
            }
        }

        pokazatyKnyhy(rezultat);
    }

    private void poshukZaRokom(BookCatalog catalog) {
        int rik = readInt("Введіть рік: ");

        List<Book> rezultat = new ArrayList<>();

        for (Book book : catalog.getBooks()) {
            if (book.getRik() > rik) {
                rezultat.add(book);
            }
        }

        pokazatyKnyhy(rezultat);
    }

    private void sortuvatyZaVydavnytstvom(BookCatalog catalog) {
        List<Book> sortedBooks = new ArrayList<>(catalog.getBooks());

        sortedBooks.sort(
                Comparator.comparing(Book::getVydavnytstvo)
        );

        System.out.println("\nКниги, відсортовані за видавництвом:");
        pokazatyKnyhy(sortedBooks);
    }

    private void pokazatyKnyhy(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Книг не знайдено.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    private int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Потрібно ввести ціле число. Спробуйте ще раз.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KnyzhkovyiDodatok dodatok = new KnyzhkovyiDodatok(scanner);
        dodatok.start();
    }
}

