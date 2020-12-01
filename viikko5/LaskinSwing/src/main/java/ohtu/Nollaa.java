package ohtu;

import javax.swing.*;
import java.util.HashMap;

public class Nollaa extends Komento {

    private HashMap<String, Komento> komennot;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int vanhaTulos, vanhaSyote;

    public Nollaa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        vanhaSyote = 0;
        vanhaTulos = 0;
        try {
            vanhaSyote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        try {
            vanhaTulos = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        syotekentta.setText("");
        tuloskentta.setText("");
        sovellus.nollaa();
        nollaa.setEnabled(false);
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + vanhaTulos);
        syotekentta.setText("" + vanhaSyote);
        sovellus.plus(vanhaTulos);

    }
}
