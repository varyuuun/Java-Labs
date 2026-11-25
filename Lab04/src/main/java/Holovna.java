
import doroga.Doroha;
import pasazhyry.*;
import transport.*;

public class Holovna {

    public static void main(String[] args) {
        
        Avtobus avtobus = new Avtobus(4);
        avtobus.posadytyPasazhyra(new Liudyna("Іван"));
        avtobus.posadytyPasazhyra(new Pozhezhnyk("Олег"));
        avtobus.posadytyPasazhyra(new Politseiskyi("Андрій"));

        Taksi taksi = new Taksi(3);
        taksi.posadytyPasazhyra(new Pozhezhnyk("Петро"));
        taksi.posadytyPasazhyra(new Politseiskyi("Максим"));


        PozhezhnaMashyna pozhezhnaMashyna = new PozhezhnaMashyna(2);
        pozhezhnaMashyna.posadytyPasazhyra(new Pozhezhnyk("Сергій"));

        PolitseiskaMashyna politseiskaMashyna =
                new PolitseiskaMashyna(2);
        politseiskaMashyna.posadytyPasazhyra(new Politseiskyi("Дмитро"));

        Doroha doroha = new Doroha();

        doroha.dodatyTransport(avtobus);
        doroha.dodatyTransport(taksi);
        doroha.dodatyTransport(pozhezhnaMashyna);
        doroha.dodatyTransport(politseiskaMashyna);

        // Виведення результатів
        System.out.println("=== ТРАНСПОРТНІ ЗАСОБИ ===");

        System.out.println("Автобус: "
                + avtobus.otrymatyZaynyatiMistsya()
                + "/" + avtobus.otrymatyMaksKilkistMists());

        System.out.println("Таксі: "
                + taksi.otrymatyZaynyatiMistsya()
                + "/" + taksi.otrymatyMaksKilkistMists());

        System.out.println("Пожежна машина: "
                + pozhezhnaMashyna.otrymatyZaynyatiMistsya()
                + "/" + pozhezhnaMashyna.otrymatyMaksKilkistMists());

        System.out.println("Поліцейська машина: "
                + politseiskaMashyna.otrymatyZaynyatiMistsya()
                + "/" + politseiskaMashyna.otrymatyMaksKilkistMists());

        System.out.println("-----------------------------");

        System.out.println("Загальна кількість людей на дорозі: "
                + doroha.otrymatyKilkistLiudei());
    }
}
