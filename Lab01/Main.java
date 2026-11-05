import java.util.Scanner;

public class Main {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverseNumber(int number) {
        int reversed = 0;

        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static int countSuperPrimes(int n) {
        int count = 0;

        for (int number = 2; number <= n; number++) {
            if (isPrime(number) && isPrime(reverseNumber(number))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть натуральне число n (від 1 до 1000): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Помилка: потрібно ввести ціле число.");
            return;
        }

        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {
            System.out.println("Помилка: n має бути від 1 до 1000.");
            return;
        }

        int result = countSuperPrimes(n);
        System.out.println("Кількість надпростих чисел від 1 до " + n + ": " + result);
    }
}
