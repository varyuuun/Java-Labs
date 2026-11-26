
package task4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AnalizatorHTMLDodatok {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AnalizatorHTML analizator = new AnalizatorHTML();
        TagFileManager fileManager = new TagFileManager();

        System.out.println("=== АНАЛІЗ HTML-ТЕГІВ ===");
        // https://example.com

        System.out.print("Введіть URL сторінки: ");
        String url = scanner.nextLine().trim();

        try {
            List<TagStatystyka> statystyka =
                    analizator.pidrakhuvatyTegy(url);

            System.out.println("\nТеги за алфавітом:");
            analizator.vyvestyStatystyku(
                    analizator.sortuvatyZaNazvoiu(statystyka)
            );

            System.out.println("\nТеги за зростанням частоти:");
            analizator.vyvestyStatystyku(
                    analizator.sortuvatyZaChastotoiu(statystyka)
            );

            System.out.print("\nВведіть шлях для збереження результатів: ");
            String shliakh = scanner.nextLine().trim();

            if (shliakh.isEmpty()) {
                System.out.println("Шлях не може бути порожнім.");
                return;
            }

            fileManager.zberehtyUFail(statystyka, shliakh);

            System.out.println("Результати успішно збережено.");

        } catch (IOException e) {
            System.out.println(
                    "Помилка отримання або збереження сторінки: "
                            + e.getMessage()
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }
}
