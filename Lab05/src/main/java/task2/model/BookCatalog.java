package task2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookCatalog implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Book> books = new ArrayList<>();

    public BookCatalog() {
        books.add(new Book("Кобзар", "Тарас Шевченко",
                "Фоліо", 2018, 320, 250));

        books.add(new Book("Лісова пісня", "Леся Українка",
                "А-БА-БА-ГА-ЛА-МА-ГА", 2020, 180, 220));

        books.add(new Book("Тигролови", "Іван Багряний",
                "Фоліо", 2019, 280, 290));

        books.add(new Book("Захар Беркут", "Іван Франко",
                "Ранок", 2021, 240, 200));

        books.add(new Book("Місто", "Валер'ян Підмогильний",
                "Фоліо", 2022, 350, 310));

        books.add(new Book("Тіні забутих предків", "Михайло Коцюбинський",
                "Ранок", 2017, 160, 180));

        books.add(new Book("Чорна рада", "Пантелеймон Куліш",
                "А-БА-БА-ГА-ЛА-МА-ГА", 2023, 300, 320));

        books.add(new Book("Кайдашева сім'я", "Іван Нечуй-Левицький",
                "Фоліо", 2020, 210, 230));

        books.add(new Book("Маруся Чурай", "Ліна Костенко",
                "А-БА-БА-ГА-ЛА-МА-ГА", 2016, 190, 270));

        books.add(new Book("Енеїда", "Іван Котляревський",
                "Ранок", 2024, 260, 280));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = new ArrayList<>(books);
    }
}
