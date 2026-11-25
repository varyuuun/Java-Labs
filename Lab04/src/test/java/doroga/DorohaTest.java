
package doroga;

import org.junit.jupiter.api.Test;
import pasazhyry.Liudyna;
import pasazhyry.Pozhezhnyk;
import pasazhyry.Politseiskyi;
import transport.*;

import static org.junit.jupiter.api.Assertions.*;

class DorohaTest {

    @Test
    void rahuieKilkistLiudeiNaDorozi() {

        Avtobus avtobus = new Avtobus(4);
        avtobus.posadytyPasazhyra(new Liudyna("Іван"));
        avtobus.posadytyPasazhyra(new Pozhezhnyk("Олег"));
        avtobus.posadytyPasazhyra(new Politseiskyi("Андрій"));

        Taksi taksi = new Taksi(3);
        taksi.posadytyPasazhyra(new Liudyna("Петро"));
        taksi.posadytyPasazhyra(new Liudyna("Максим"));

        PozhezhnaMashyna pozhezhnaMashyna =
                new PozhezhnaMashyna(2);
        pozhezhnaMashyna.posadytyPasazhyra(
                new Pozhezhnyk("Сергій"));

        PolitseiskaMashyna politseiskaMashyna =
                new PolitseiskaMashyna(2);
        politseiskaMashyna.posadytyPasazhyra(
                new Politseiskyi("Дмитро"));

        Doroha doroha = new Doroha();

        doroha.dodatyTransport(avtobus);
        doroha.dodatyTransport(taksi);
        doroha.dodatyTransport(pozhezhnaMashyna);
        doroha.dodatyTransport(politseiskaMashyna);

        assertEquals(7, doroha.otrymatyKilkistLiudei());
    }

    @Test
    void porozhnyaDorohaNeMiePasazhyriv() {
        Doroha doroha = new Doroha();

        assertEquals(0, doroha.otrymatyKilkistLiudei());
    }

    @Test
    void neMozhnaDodatyPorozhniiTransport() {
        Doroha doroha = new Doroha();

        assertThrows(IllegalArgumentException.class,
                () -> doroha.dodatyTransport(null));
    }
}
