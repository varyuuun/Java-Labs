import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private String surname;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String street;
    private String house;
    private String apartment;

    public Student(String surname, String name,
                   LocalDate birthDate, String phone,
                   String street, String house,
                   String apartment) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd.MM.uuuu");

        return "Прізвище: " + surname +
                "\nІм'я: " + name +
                "\nДата народження: " + birthDate.format(formatter) +
                "\nТелефон: " + phone +
                "\nАдреса: вул. " + street +
                ", буд. " + house +
                ", кв. " + apartment;
    }
}
