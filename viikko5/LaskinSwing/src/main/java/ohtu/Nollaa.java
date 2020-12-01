package ohtu;

import javax.swing.*;

public class Nollaa extends Komento {


    public Nollaa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int arvo = getSyotekentanArvo();
        sovellus.nollaa();
        setLukukenttienArvot(sovellus.tulos(), arvo);
    }

    @Override
    public void peru() {
        setLukukenttienArvot(vanhaTulos, vanhaSyote);
        sovellus.nollaa();
        sovellus.plus(vanhaTulos);

    }
}
