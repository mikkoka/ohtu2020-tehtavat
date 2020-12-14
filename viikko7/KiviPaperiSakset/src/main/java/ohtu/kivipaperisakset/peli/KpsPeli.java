package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.IO;

public abstract class KpsPeli {

    protected IO io;
    protected boolean yksinpeli;

    public KpsPeli(IO io) {
        this.io = io;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        String tokanSiirto = teeToisenPelaajanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.nextLine();
            tokanSiirto = teeToisenPelaajanSiirto();
            if (yksinpeli) paivitaTekoaly(ekanSiirto);
        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

    protected abstract String teeToisenPelaajanSiirto();
    protected abstract void paivitaTekoaly(String ekanSiirto);
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
