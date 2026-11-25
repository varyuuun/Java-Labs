
package transport;

import pasazhyry.Liudyna;

public abstract class Avtomobil<T extends Liudyna>
        extends TransportnyiZasib<T> {

    public Avtomobil(int maksKilkistMists) {
        super(maksKilkistMists);
    }
}
