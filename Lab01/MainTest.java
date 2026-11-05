
public class MainTest {

    private static int passed = 0;
    private static int total = 0;

    public static void check(String name, boolean condition) {
        total++;

        if (condition) {
            passed++;
            System.out.println("[OK] " + name);
        } else {
            System.out.println("[ERROR] " + name);
        }
    }

    public static void main(String[] args) {


        check("Просте число 2", Main.isPrime(2));
        check("Просте число 13", Main.isPrime(13));
        check("Число 1 не просте", !Main.isPrime(1));
        check("Число 15 не просте", !Main.isPrime(15));


        check("13 -> 31", Main.reverseNumber(13) == 31);
        check("120 -> 21", Main.reverseNumber(120) == 21);
        check("7 -> 7", Main.reverseNumber(7) == 7);


        check("n = 1", Main.countSuperPrimes(1) == 0);
        check("n = 2", Main.countSuperPrimes(2) == 1);
        check("n = 13", Main.countSuperPrimes(13) == 6);
        check("n = 100", Main.countSuperPrimes(100) == 13);
        check("n = 1000", Main.countSuperPrimes(1000) == 56);

        System.out.println();
        System.out.println("Успішно пройдено тестів: "
                + passed + " із " + total);
    }
}
