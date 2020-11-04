package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface KirjanpitoPalvelu {
    void lisaaTapahtuma(String tapahtuma);
    ArrayList<String> getTapahtumat();
}
