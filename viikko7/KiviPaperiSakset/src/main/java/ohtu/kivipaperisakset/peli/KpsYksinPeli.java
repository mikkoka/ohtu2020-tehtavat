package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.IO;
import ohtu.kivipaperisakset.aly.Aly;

public abstract class KpsYksinPeli extends KpsPeli {

    protected Aly tekoaly;
    public KpsYksinPeli (IO io, Aly tekoaly) {
        super(io);
        this.tekoaly = tekoaly;
        yksinpeli = true;
    }

    @Override
    protected String teeToisenPelaajanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    @Override
    protected void paivitaTekoaly(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }

}
