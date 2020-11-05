package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    @Autowired
    private VarastoJarjestelma varasto;
    @Autowired
    private PankkiPalvelu pankki;
    private Ostoskori ostoskori;
    @Autowired
    private ViiteenGeneroija viitegeneraattori;
    private String kaupanTili;

/*    public Kauppa(ViiteenGeneroija vg, VarastoJarjestelma vj, PankkiPalvelu p) {
        varasto = vj;
        pankki = p;
        viitegeneraattori = vg;
        kaupanTili = "33333-44455";
    }*/

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}