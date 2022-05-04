package eserciziNonUsciti;

import prog.io.*;
import prog.utili.Frazione;
import prog.utili.Sequenza;

/*
Scrivere il metodo main (della classe Confronta) che:
1. acquisisce dallo standard input una sequenza A di numeri reali inseriti uno dopo l’altro (tale sequenza termina
quando viene letto il numero 0)
2. acquisisce una sequenza B di frazioni (istanze della classe Frazione) inserite una dopo l’altra (tale sequenza
termina quando viene letta una sequenza minore di 0).
3. stampa le frazioni in B che superano almeno la meta' dei numeri in A.
Nel caso in cui almeno una delle due sequenze fosse vuota, il metodo si deve interrompere, stampando un opportuno
messaggio di errore. Tra i metodi a disposizione, si ricordano i metodi isMinore, getNumeratore, getDenominatore,
della classe Frazione e i metodi add e size della classe generica Seq
*/
public class sequenza {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Sequenza<Double> numeri = new Sequenza<Double>();
        Sequenza<Frazione> frazioni = new Sequenza<Frazione>();

        double numero = 0;
        int k = 0;
        Frazione f;

        // inserimento numeri
        do {
            numero = in.readDouble("numero per la sequenza:  ");
            numeri.add(numero);
        } while (numero != 0);

        out.println("Inserimento numeri terminato\n");

        do {
            f = new Frazione(in.readInt("num:   "), (in.readInt("den:  ")));
            if (!f.isMinore(new Frazione(0)))
                frazioni.add(f);
        } while (!f.isMinore(new Frazione(0)));

        out.println("Inserimento frazioni terminato\n");

        if (numeri.size() > 0 && frazioni.size() > 0) {
            for (int x = 0; x < frazioni.size(); x++) {
                k = 0;
                for (Double d : numeri) {
                    if ((double) f.getNumeratore() / f.getDenominatore() > d)
                        k++;
                    if (k > numeri.size() / 2)
                        out.println(f);

                }
            }
        } else
            out.print("Una delle due sequenze e' vuota");
    }
}