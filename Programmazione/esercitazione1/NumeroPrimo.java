package esercitazione1;

import prog.io.*;

public class NumeroPrimo {
    public static void main(String[] args) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        ConsoleInputManager in = new ConsoleInputManager();
        int x;
        int k = 0;
        x = in.readInt("Inserisci un numero: ");

        for (int i = 1; i <= x; i++) {
            if (x % i == 0)
                k++;
        }
        if (k > 2)
            out.println("Il numero non e' primo");
        else
            out.println("il numero e' primo");
    }
}