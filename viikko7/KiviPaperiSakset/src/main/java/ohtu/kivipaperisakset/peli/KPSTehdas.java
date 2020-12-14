package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.IO;
import ohtu.kivipaperisakset.aly.Tekoaly;
import ohtu.kivipaperisakset.aly.TekoalyParannettu;

public class KPSTehdas {
    public static KpsPeli tekoalyPeli(IO io) {
        return new KPSTekoaly(io, new Tekoaly());
    }
    public static KpsPeli parempiTekoalyPeli(IO io) {
        return new KPSTekoaly(io, new TekoalyParannettu(20));
    }
    public static KpsPeli kaksinPeli(IO io) {
        return new KPSPelaajaVsPelaaja(io);
    }


}
