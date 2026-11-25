
package controller;

import model.Book;
import model.BookCatalog;
import view.BookView;

import java.util.Arrays;
import java.util.Comparator;

public class BookController {

    private BookCatalog catalog;
    private BookView view;

    public BookController(BookCatalog catalog, BookView view) {
        this.catalog = catalog;
        this.view = view;
    }

    public void start() {

        view.showMessage("\nПочатковий список книг:");
        view.showBooks(catalog.getBooks());

        boolean running = true;

        while (running) {
            int choice = view.showMenu();

            switch (choice) {
                case 1:
                    searchByAuthor();
                    break;

                case 2:
                    searchByPublisher();
                    break;

                case 3:
                    searchByYear();
                    break;

                case 4:
                    sortByPublisher();
                    break;

                case 0:
                    view.showMessage("Роботу програми завершено.");
                    view.closeScanner();
                    running = false;
                    break;

                default:
                    view.showMessage("Невірний пункт меню. Спробуйте ще раз.");
            }
        }
    }

    private void searchByAuthor() {
        Book[] books = catalog.getBooks();

        String author = books[(int) (Math.random() * books.length)].getAuthor();

        view.showMessage("\nПошук книг автора: " + author);

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toArray(Book[]::new);

        view.showBooks(result);
    }

    private void searchByPublisher() {
        Book[] books = catalog.getBooks();

        String publisher = books[(int) (Math.random() * books.length)].getPublisher();

        view.showMessage("\nПошук книг видавництва: " + publisher);

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .toArray(Book[]::new);

        view.showBooks(result);
    }

    private void searchByYear() {
        Book[] books = catalog.getBooks();

        int year = books[(int) (Math.random() * books.length)].getYear();

        view.showMessage("\nПошук книг, виданих після " + year + " року:");

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getYear() > year)
                .toArray(Book[]::new);

        view.showBooks(result);
    }

    private void sortByPublisher() {
        Book[] books = catalog.getBooks().clone();

        Arrays.sort(books, Comparator.comparing(Book::getPublisher));

        view.showMessage("\nКниги, відсортовані за видавництвом:");

        view.showBooks(books);
    }
}
