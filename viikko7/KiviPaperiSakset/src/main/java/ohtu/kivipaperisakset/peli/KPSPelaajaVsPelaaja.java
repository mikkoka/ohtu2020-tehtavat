package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.IO;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KpsPeli {

    private static final Scanner scanner = new Scanner(System.in);

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
        yksinpeli = false;
    }

    @Override
    protected String teeToisenPelaajanSiirto() {
        io.print("Toisen pelaajan siirto: ");
        return io.nextLine();
    }

    @Override
    protected void paivitaTekoaly(String ekanSiirto) {
        // do nothing
    }
}