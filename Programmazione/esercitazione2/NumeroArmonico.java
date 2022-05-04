package esercitazione2;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;

public class NumeroArmonico {

    public static void main(String[] s) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        out.println("=== Calcoliamo H(n) = 1 + 1/2 + 1/3 +...+ 1/n ===");

        // lettura di n
        int n = in.readInt("Inserisci n > ");
        // controllo su n
        // calcolo del risultato
        Frazione risultato = new Frazione(1);
        for (int i = 2; i <= n; i++)
            risultato = risultato.piu(new Frazione(1, i));

        // comunicazione risultato
        out.println("H(n) come frazione è " + risultato.toString());

        double valore = (double) risultato.getNumeratore() / risultato.getDenominatore();
        out.println("H(n) come double è " + valore);
    }
}
