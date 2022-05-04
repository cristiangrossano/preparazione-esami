package esercitazione5;

import prog.io.*;
import java.util.Random;

public class metodiArray {

    // creazione dell'array e rimpimento dei vari "cassetti"
    public static int[] generatoreArray(int dimensione, int valoremassimo) {
        Random generatore = new Random();
        int[] array = new int[dimensione];

        for (int i = 0; i < dimensione; i++) {
            array[i] = generatore.nextInt(valoremassimo);
        }

        return array;
    }

    // output in forma string dell'array
    public static String inStringa(String separatore, int array[]) {
        String risultato = "[ ";

        for (int i = 0; i < array.length; i++) {
            risultato = risultato + array[i];
            risultato = risultato + separatore;
        }
        risultato = risultato + " ]";
        return risultato;
    }

    public static int[] contrario(int[] a) {
        int[] inverso = new int[a.length];

        for (int i = 0; i < inverso.length; i++) {
            inverso[i] = a[(a.length - 1) - i];
        }
        return inverso;
    }

    public static int[] maggiorPosizione(int[] a, int[] b) {
        int[] risultato = new int[a.length];

        for (int i = 0; i < risultato.length; i++) {
            risultato[i] = a[i] >= b[i] ? a[i] : b[i];
        }
        return risultato;
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int dim = in.readInt("Inserisci la dimensione desiderata per l'array.\n");
        int max = in.readInt("INserisci il valore massimo desiderato nell'array.\n");

        int[] array1 = generatoreArray(dim, max);
        int[] array2 = generatoreArray(dim, max);

        out.println("a= " + inStringa(", ", array1));
        out.println("b= " + inStringa(", ", array2));

        out.println("a al contrario= " + contrario(array1));

        int[] maxPosizioni = maggiorPosizione(array1, array2);
        out.println("array massimo = " + maxPosizioni);
    }
}