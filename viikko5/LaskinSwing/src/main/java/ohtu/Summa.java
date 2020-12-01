package ohtu;

import javax.swing.*;


public class Summa extends Komento {

    public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }


    public void suorita() {
        int arvo = getSyotekentanArvo();
        sovellus.plus(arvo);
        setLukukenttienArvot(sovellus.tulos(), arvo);
    }

    @Override
    public void peru() {
        setLukukenttienArvot(vanhaTulos - vanhaSyote, vanhaSyote);
        sovellus.miinus(vanhaSyote);







    }
}
