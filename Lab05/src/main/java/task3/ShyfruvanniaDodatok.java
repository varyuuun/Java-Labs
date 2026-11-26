package task3;

import java.io.IOException;
import java.util.Scanner;

public class ShyfruvanniaDodatok {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShyfruvanniaManager manager = new ShyfruvanniaManager();

        System.out.println("=== ШИФРУВАННЯ ТЕКСТУ ===");
        System.out.println("1. Зашифрувати файл");
        System.out.println("2. Розшифрувати файл");
        System.out.print("Ваш вибір: ");

        String vybir = scanner.nextLine().trim();

        if (!vybir.equals("1") && !vybir.equals("2")) {
            System.out.println("Невірний пункт меню.");
            return;
        }

        System.out.print("Введіть шлях до вхідного файлу: ");
        String vhidnyiFail = scanner.nextLine().trim();

        System.out.print("Введіть шлях до вихідного файлу: ");
        String vyhidnyiFail = scanner.nextLine().trim();

        System.out.print("Введіть ключовий символ: ");
        String kliuch = scanner.nextLine();

        if (vhidnyiFail.isEmpty() || vyhidnyiFail.isEmpty()) {
            System.out.println("Шлях до файлу не може бути порожнім.");
            return;
        }

        if (vhidnyiFail.equalsIgnoreCase(vyhidnyiFail)) {
            System.out.println("Вхідний та вихідний файли повинні відрізнятися.");
            return;
        }

        if (kliuch.length() != 1) {
            System.out.println("Ключ повинен складатися з одного символу.");
            return;
        }

        try {
            if (vybir.equals("1")) {
                manager.zashyfruvaty(
                        vhidnyiFail, vyhidnyiFail, kliuch.charAt(0)
                );

                System.out.println("Файл успішно зашифровано.");

            } else {
                manager.deshyfruvaty(
                        vhidnyiFail, vyhidnyiFail, kliuch.charAt(0)
                );

                System.out.println("Файл успішно розшифровано.");
            }

        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        }
    }
}
