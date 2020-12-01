package ohtu;

import javax.swing.*;
import java.util.HashMap;

public abstract class Komento {

    protected HashMap<String, Komento> komennot;
    protected JButton nollaa;
    protected JButton undo;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected Sovelluslogiikka sovellus;
    protected int vanhaTulos, vanhaSyote;

    public Komento(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    protected int getSyotekentanArvo() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }

    protected void setLukukenttienArvot(int laskunTulos, int arvo) {
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);

        vanhaTulos = laskunTulos;
        vanhaSyote = arvo;
    }

    public abstract void suorita();
    public abstract void peru();
}
