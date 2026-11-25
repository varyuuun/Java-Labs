
package doroga;

import pasazhyry.Liudyna;
import transport.TransportnyiZasib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doroha {

    private List<TransportnyiZasib<? extends Liudyna>> transportniZasoby =
            new ArrayList<>();

    // Додавання транспортного засобу на дорогу
    public void dodatyTransport(TransportnyiZasib<? extends Liudyna> transport) {
        if (transport == null) {
            throw new IllegalArgumentException(
                    "Транспортний засіб не може бути відсутнім."
            );
        }

        transportniZasoby.add(transport);
    }

    // Підрахунок загальної кількості людей
    public int otrymatyKilkistLiudei() {
        int kilkist = 0;

        for (TransportnyiZasib<? extends Liudyna> transport : transportniZasoby) {
            kilkist += transport.otrymatyZaynyatiMistsya();
        }

        return kilkist;
    }

    // Отримання списку транспорту
    public List<TransportnyiZasib<? extends Liudyna>> otrymatyTransport() {
        return Collections.unmodifiableList(transportniZasoby);
    }
}
