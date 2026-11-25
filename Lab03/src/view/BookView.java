
package view;

import model.Book;
import java.util.Scanner;

public class BookView {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n========== КНИГИ ==========");
        System.out.println("1. Пошук книг за автором");
        System.out.println("2. Пошук книг за видавництвом");
        System.out.println("3. Пошук книг після певного року");
        System.out.println("4. Сортування за видавництвом");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Введіть номер пункту меню!");
            scanner.nextLine();
            System.out.print("Ваш вибір: ");
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void showBooks(Book[] books) {
        if (books.length == 0) {
            System.out.println("Книг не знайдено.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}
