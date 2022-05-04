package Gennaio20;

import prog.io.*;
import prog.utili.Frazione;

public class OperazioniFrazioni {
    static void operazioni() {
        ConsoleInputManager in = new ConsoleInputManager();
        int dim = in.readInt("Inserisci la dimensione dell'array delle frazioni");
        Frazione[] arrayDiFrazioni = new Frazione[dim];

        for (int i = 0; i < arrayDiFrazioni.length; i++) {
            try {
            } catch (Exception e) {
                System.out.println("Errore nelle frazioni");
            }
        }
    }

    public static void main(String[] args) {
    }
}

/*
 * 
 * Scrivere il codice del metodo statico operazioniFrazioni che:
 * 1. legge dallo standard input un numero intero n (assumere l’esistenza della
 * variabile in)
 * 2. legge dallo standard input n frazioni e le memorizza in un array
 * 3. legge dallo standard input due numeri interi x, y (0 ≤ x < y < n)
 * 4. scrive sullo standard output la somma delle frazioni comprese tra le
 * posizioni x e y dell’array ed il prodotto delle
 * rimanenti frazioni (assumere l’esistenza della variabile out)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * static void operazioniFrazioni() {
 * int n = in.readInt("inserire la dimensione dell’array di frazioni: ");
 * Frazione[] arrfraz = new Frazione[n];
 * for (int i=0; i>n; i++)
 * arrfraz[i] = new Frazione(in.readInt(), in.readInt());
 * int x = in.readInt();
 * int y = in.readInt();
 * if (x >= 0 && x < y && y < n) {
 * Frazione somma = new Frazione(0);
 * Frazione Prodotto = new Frazione(1);
 * for (int i=0; i<=n; i++)
 * if (x<=i && i<=y)somma = somma.piu(arrfraz[i]);
 * else
 * prodotto = prodotto.per(arrfraz[i]);
 * out.println("somma: " + somma + ", prodotto: " + prodotto);
 * }
 * }
 */