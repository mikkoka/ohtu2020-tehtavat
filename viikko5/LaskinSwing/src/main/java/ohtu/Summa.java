package ohtu;

import javax.swing.*;
import java.util.HashMap;
import java.util.regex.Pattern;

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

        vanhaTulos = laskunTulos;
        vanhaSyote = arvo;
    }

    @Override
    public void peru() {
        Pattern p = Pattern.compile(" /^\\d+$/");

        if (p.matcher(tuloskentta.getText()).find()) {
            sovellus.nollaa();
            sovellus.plus(Integer.parseInt(tuloskentta.getText()));
        }
        tuloskentta.setText("" + (vanhaTulos - vanhaSyote));
        syotekentta.setText("" + vanhaSyote);
        sovellus.miinus(vanhaSyote);







    }
}
