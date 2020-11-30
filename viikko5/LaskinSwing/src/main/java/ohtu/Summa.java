package ohtu;

import javax.swing.*;
import java.util.HashMap;

public class Summa extends Komento {

    private HashMap<String, Komento> komennot;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int vanhaTulos, vanhaSyote;

    public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }


    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        syotekentta.setText("");
        sovellus.plus(arvo);
        int laskunTulos = sovellus.tulos();

        tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);

        vanhaTulos = laskunTulos - arvo;
        vanhaSyote = arvo;
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + vanhaTulos);
        syotekentta.setText("" + vanhaSyote);

    }
}
