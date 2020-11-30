package ohtu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {

    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Komento edellinen = null;
    private JButton undo;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        this.undo = undo;
        this.komennot.put(plus, new Summa(tuloskentta, syotekentta,  nollaa, undo, sovellus) );
        this.komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus) );
        this.komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta,  nollaa, undo, sovellus) );
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(undo)) edellinen.peru();
        else {
            Komento k = komennot.get(ae.getSource());
            k.suorita();
            edellinen = k;
        }
    }
 
}