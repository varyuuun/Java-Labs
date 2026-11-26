package task1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NaityRiadok {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vykonaty(scanner);
    }

    public static void vykonaty(Scanner scanner) {

        System.out.print("Введіть шлях до файлу: ");
        String shliakh = scanner.nextLine().trim();

        String naidovshyiRiadok = null;
        int maksKilkistSliv = -1;
        int nomerRiadka = 0;
        int nomerMaksRiadka = 0;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(shliakh),
                        StandardCharsets.UTF_8))) {

            String riadok;

            while ((riadok = reader.readLine()) != null) {

                nomerRiadka++;

                String obroblenyiRiadok = riadok.strip();

                int kilkistSliv;

                if (obroblenyiRiadok.isEmpty()) {
                    kilkistSliv = 0;
                } else {
                    kilkistSliv = obroblenyiRiadok.split("\\s+").length;
                }

                if (kilkistSliv > maksKilkistSliv) {
                    maksKilkistSliv = kilkistSliv;
                    naidovshyiRiadok = riadok;
                    nomerMaksRiadka = nomerRiadka;
                }
            }

            if (naidovshyiRiadok == null) {
                System.out.println("Файл порожній.");
            } else {
                System.out.println("Рядок з найбільшою кількістю слів:");
                System.out.println(naidovshyiRiadok);
                System.out.println("Кількість слів: " + maksKilkistSliv);
                System.out.println("Номер рядка: " + nomerMaksRiadka);
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}

