package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.peli.KPSTehdas;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static IO io = new KonsoliIO();

    public static void main(String[] args) {

        while (true) {
            tulostaVaihtoehdot();
            String vastaus = io.nextLine();
            if (vastaus.endsWith("a")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                (KPSTehdas.kaksinPeli(io)).pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                (KPSTehdas.tekoalyPeli(io)).pelaa();
            } else if (vastaus.endsWith("c")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                (KPSTehdas.parempiTekoalyPeli(io)).pelaa();
            } else {
                break;
            }

        }

    }
    private static void tulostaVaihtoehdot() {
        io.print("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }
}
