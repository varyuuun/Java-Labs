
package transport;

import pasazhyry.Liudyna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TransportnyiZasib<T extends Liudyna> {

    private int maksKilkistMists;
    private List<T> pasazhyry = new ArrayList<>();

    public TransportnyiZasib(int maksKilkistMists) {
        if (maksKilkistMists <= 0) {
            throw new IllegalArgumentException(
                    "Кількість місць повинна бути більшою за 0."
            );
        }

        this.maksKilkistMists = maksKilkistMists;
    }

    // Отримання максимальної кількості місць
    public int otrymatyMaksKilkistMists() {
        return maksKilkistMists;
    }

    // Отримання кількості зайнятих місць
    public int otrymatyZaynyatiMistsya() {
        return pasazhyry.size();
    }

    // Посадка пасажира
    public void posadytyPasazhyra(T pasazhyr) {
        if (pasazhyr == null) {
            throw new IllegalArgumentException(
                    "Пасажир не може бути відсутнім."
            );
        }

        if (pasazhyry.size() >= maksKilkistMists) {
            throw new IllegalStateException(
                    "У транспортному засобі немає вільних місць."
            );
        }

        pasazhyry.add(pasazhyr);
    }

    // Висадка пасажира
    public void vysadytyPasazhyra(T pasazhyr) {
        if (!pasazhyry.remove(pasazhyr)) {
            throw new IllegalArgumentException(
                    "Цього пасажира немає у транспортному засобі."
            );
        }
    }

    // Отримання списку пасажирів
    public List<T> otrymatyPasazhyry() {
        return Collections.unmodifiableList(pasazhyry);
    }
}
