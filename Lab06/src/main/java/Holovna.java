import perekladach.Slovnyk;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Holovna {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Slovnyk slovnyk = new Slovnyk();

        boolean pratsiuie = true;

        while (pratsiuie) {

            System.out.println("\n======= АНГЛО-УКРАЇНСЬКИЙ ПЕРЕКЛАДАЧ =======");
            System.out.println("1. Переглянути словник");
            System.out.println("2. Додати нове слово");
            System.out.println("3. Перекласти фразу");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            String vybir = scanner.nextLine().trim();

            switch (vybir) {

                case "1":
                    System.out.println("\nСловник:");

                    Map<String, String> vsiSlova =
                            new TreeMap<>(slovnyk.otrymatySlovnyk());

                    for (Map.Entry<String, String> entry : vsiSlova.entrySet()) {
                        System.out.println(
                                entry.getKey() + " — " + entry.getValue()
                        );
                    }
                    break;

                case "2":
                    System.out.print("Введіть англійське слово: ");
                    String angliiske = scanner.nextLine();

                    System.out.print("Введіть український переклад: ");
                    String ukrainske = scanner.nextLine();

                    try {
                        slovnyk.dodatySlovo(angliiske, ukrainske);
                        System.out.println("Слово успішно додано до словника.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.print("Введіть фразу англійською: ");
                    String fraza = scanner.nextLine();

                    if (fraza.isBlank()) {
                        System.out.println("Фраза не може бути порожньою.");
                    } else {
                        String rezultat = slovnyk.pereklastyFrazu(fraza);

                        System.out.println("Переклад: " + rezultat);
                    }
                    break;

                case "0":
                    System.out.println("Роботу перекладача завершено.");
                    pratsiuie = false;
                    break;

                default:
                    System.out.println("Невірний пункт меню. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
