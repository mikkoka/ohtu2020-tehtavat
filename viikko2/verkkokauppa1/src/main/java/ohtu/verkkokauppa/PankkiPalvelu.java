package ohtu.verkkokauppa;

public interface PankkiPalvelu {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
