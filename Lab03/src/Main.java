import controller.BookController;
import model.BookCatalog;
import view.BookView;

public class Main {

    public static void main(String[] args) {

        BookCatalog catalog = new BookCatalog();

        BookView view = new BookView();

        BookController controller =
                new BookController(catalog, view);

        controller.start();
    }
}