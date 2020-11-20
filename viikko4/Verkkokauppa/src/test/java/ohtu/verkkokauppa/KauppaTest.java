package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        when(viite.uusi()).thenReturn(42);

        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.saldo(3)).thenReturn(0);

        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "voi", 5));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "loppunut_tuote", 5));
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());
    }

    // varmista että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla,
    // tilinumeroilla ja summalla
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(5));
    }

    // aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa on
    // ja suoritetaan ostos, varmista että kutsutaan pankin metodia tilisiirto oikealla
    // asiakkaalla, tilinumerolla ja summalla
    @Test
    public void KahdenEriTavaranOstonJalkeenOikeaTilisiirto() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(10));
    }

    // aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta, jota on varastossa
    // tarpeeksi ja suoritetaan ostos, varmista että kutsutaan pankin metodia tilisiirto
    // oikealla asiakkaalla, tilinumerolla ja summalla
    @Test
    public void KahdenSamanTavaranOstonJalkeenOikeaTilisiirto() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(10));
    }

    // aloitetaan asiointi, koriin lisätään tuote, jota on varastossa tarpeeksi ja
    // tuote joka on loppu ja suoritetaan ostos, varmista että kutsutaan pankin
    // metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla

    @Test
    public void VarastossaOlevanJaVarastostaPuuttuvanTuotteenOstonJalkeenOikeaTilisiirto() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(5));
    }

    @Test
    public void aloitaAsiointiNollaaOstoskorin() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(0));
    }

    // varmista, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle
    @Test
    public void uusiViitenumeroJokaiselleMaksulle() {

        Kauppa k = new Kauppa(varasto, pankki, viite);
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(viite, times(2)).uusi();
    }


}

