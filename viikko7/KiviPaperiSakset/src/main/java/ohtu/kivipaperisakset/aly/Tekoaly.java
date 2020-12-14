package ohtu.kivipaperisakset.aly;

public class Tekoaly extends Aly {

    public Tekoaly() {
        siirto = 0;
    }

    int siirto;
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään?
    }



}
