package ohtu;

import javax.swing.*;

public class Erotus extends Komento{

    public Erotus(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int arvo = getSyotekentanArvo();
        sovellus.miinus(arvo);
        setLukukenttienArvot(sovellus.tulos(), arvo);
    }

    @Override
    public void peru() {
        setLukukenttienArvot(vanhaTulos + vanhaSyote, vanhaSyote);
        sovellus.plus(vanhaSyote);

    }
}
