package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.IO;
import ohtu.kivipaperisakset.aly.Aly;

import java.util.Scanner;

public class KPSTekoaly extends KpsYksinPeli {

    private static final Scanner scanner = new Scanner(System.in);

    public KPSTekoaly(IO io, Aly tekoaly) {
        super(io, tekoaly);
    }

}