package ohtu.verkkokauppa;

public interface VarastoJarjestelma {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    default void alustaTuotteet() {
    }
}
