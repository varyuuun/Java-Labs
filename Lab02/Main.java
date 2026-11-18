import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd.MM.uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    public static String readField(Scanner scanner, String prompt,
                                   String pattern) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (value.matches(pattern)) {
                return value;
            }

            System.out.println("Помилка введення. Спробуйте ще раз.");
        }
    }


    public static LocalDate readBirthDate(Scanner scanner) {
        while (true) {
            System.out.print("Дата народження (дд.мм.рррр): ");
            String input = scanner.nextLine().trim();

            try {
                LocalDate date = LocalDate.parse(input, DATE_FORMAT);

                if (!date.isAfter(LocalDate.now())) {
                    return date;
                }

                System.out.println("Дата не може бути в майбутньому.");
            } catch (DateTimeParseException e) {
                System.out.println("Некоректна дата. Спробуйте ще раз.");
            }
        }
    }


    public static Student createStudent(Scanner scanner) {
        String surname = readField(scanner,
                "Прізвище: ", "[\\p{L}'’-]{2,40}");

        String name = readField(scanner,
                "Ім'я: ", "[\\p{L}'’-]{2,40}");

        LocalDate birthDate = readBirthDate(scanner);

        String phone = readField(scanner,
                "Телефон (+380XXXXXXXXX): ", "\\+380\\d{9}");

        String street = readField(scanner,
                "Вулиця: ", "[\\p{L}\\d\\s.'’/-]{2,60}");

        String house = readField(scanner,
                "Будинок: ", "\\d+[\\p{L}]?(/\\d+)?");

        String apartment = readField(scanner,
                "Квартира: ", "[1-9]\\d*");

        return new Student(surname, name, birthDate,
                phone, street, house, apartment);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== ЖУРНАЛ КУРАТОРА ===");
            System.out.println("1. Додати запис");
            System.out.println("2. Показати всі записи");
            System.out.println("0. Вийти");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    Student student = createStudent(scanner);
                    students.add(student);
                    System.out.println("Запис успішно додано!");
                    break;

                case "2":
                    if (students.isEmpty()) {
                        System.out.println("Журнал порожній.");
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println("\nЗапис №" + (i + 1));
                            System.out.println(students.get(i));
                        }
                    }
                    break;

                case "0":
                    System.out.println("Роботу завершено.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невідома команда.");
            }
        }
    }
}
