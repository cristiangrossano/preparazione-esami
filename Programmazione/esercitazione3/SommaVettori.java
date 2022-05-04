package esercitazione3;

import java.util.*;
import prog.io.*;

public class SommaVettori {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();

        Random caso = new Random();
        int dimensioneArray = in.readInt("Inserisci la dimensione dell'array:   ");
        int valoreMassimo = in.readInt("Inserisci il valore massimo dell'array:     ");

        int[] array1 = new int[dimensioneArray];
        int[] array2 = new int[dimensioneArray];
        int[] somma = new int[dimensioneArray];

        for (int i = 0; i < dimensioneArray; i++) {
            array1[i] = caso.nextInt(valoreMassimo * 2) - valoreMassimo;
            array2[i] = caso.nextInt(valoreMassimo * 2) - valoreMassimo;
            somma[i] = array1[i] + array2[i];
        }

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(somma));

    }
}
