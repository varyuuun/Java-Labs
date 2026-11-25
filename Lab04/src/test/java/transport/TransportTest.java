
package transport;

import org.junit.jupiter.api.Test;
import pasazhyry.Liudyna;
import pasazhyry.Pozhezhnyk;
import pasazhyry.Politseiskyi;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void avtobusPerevozytRiznykhPasazhyriv() {
        Avtobus avtobus = new Avtobus(3);

        avtobus.posadytyPasazhyra(new Liudyna("Іван"));
        avtobus.posadytyPasazhyra(new Pozhezhnyk("Олег"));
        avtobus.posadytyPasazhyra(new Politseiskyi("Андрій"));

        assertEquals(3, avtobus.otrymatyZaynyatiMistsya());
    }

    @Test
    void taksiPerevozytRiznykhPasazhyriv() {
        Taksi taksi = new Taksi(3);

        taksi.posadytyPasazhyra(new Liudyna("Іван"));
        taksi.posadytyPasazhyra(new Pozhezhnyk("Олег"));

        assertEquals(2, taksi.otrymatyZaynyatiMistsya());
    }

    @Test
    void pozhezhnaMashynaPerevozytPozhezhnykiv() {
        PozhezhnaMashyna mashyna = new PozhezhnaMashyna(2);

        mashyna.posadytyPasazhyra(new Pozhezhnyk("Олег"));

        assertEquals(1, mashyna.otrymatyZaynyatiMistsya());
    }

    @Test
    void politseiskaMashynaPerevozytPolitseiskykh() {
        PolitseiskaMashyna mashyna = new PolitseiskaMashyna(2);

        mashyna.posadytyPasazhyra(new Politseiskyi("Андрій"));

        assertEquals(1, mashyna.otrymatyZaynyatiMistsya());
    }

    @Test
    void neMozhnaPosadytyPasazhyraKolyMistsyaZaynyati() {
        Taksi taksi = new Taksi(1);

        taksi.posadytyPasazhyra(new Liudyna("Іван"));

        assertThrows(IllegalStateException.class,
                () -> taksi.posadytyPasazhyra(new Liudyna("Олег")));
    }

    @Test
    void neMozhnaVysadytyPasazhyraYakogoNemaie() {
        Taksi taksi = new Taksi(2);

        Liudyna pasazhyr = new Liudyna("Іван");

        assertThrows(IllegalArgumentException.class,
                () -> taksi.vysadytyPasazhyra(pasazhyr));
    }

    @Test
    void mozhnaVysadytyPasazhyraYakyiIe() {
        Taksi taksi = new Taksi(2);

        Liudyna pasazhyr = new Liudyna("Іван");
        taksi.posadytyPasazhyra(pasazhyr);

        taksi.vysadytyPasazhyra(pasazhyr);

        assertEquals(0, taksi.otrymatyZaynyatiMistsya());
    }

    @Test
    void neMozhnaStvorytyTransportBezMists() {
        assertThrows(IllegalArgumentException.class,
                () -> new Avtobus(0));
    }
}
