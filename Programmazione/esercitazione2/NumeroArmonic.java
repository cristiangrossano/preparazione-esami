package esercitazione2;

import prog.io.*;
import prog.utili.Frazione;

public class NumeroArmonic {
    public static void main(String[] args) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        ConsoleInputManager in = new ConsoleInputManager();

        int numero = in.readInt("Inserisci il numero di cui vuoi conoscere il numero armonico");
        
        Frazione Risultato = new Frazione(1);

        for (int i = 2; i < numero; i++) {
            Risultato = Risultato.piu(new Frazione(1, i));
        }

        out.println("Il risultato e':  " + Risultato.toString());

        double valore = (double) Risultato.getNumeratore() / Risultato.getDenominatore();
        out.println(valore);
    }
}
