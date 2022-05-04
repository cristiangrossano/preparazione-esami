package esercitazione1;

import prog.io.*;

public class EstraiCifre {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int cifre[] = new int[100];

        int numero = in.readInt("Inserisci il numero da analizzare!");
        int lunghezza = String.valueOf(numero).length();

        if (numero > 0)
            out.println("Il numero e' positivo");
        else
            out.println("il numero e' negativo");

        for (int i = 0; i < lunghezza; i++) {
            int diviso = numero % 10;
            cifre[i] = diviso;
            numero = numero / 10;
        }
        for (int x = 0; x < lunghezza; x++) {
            out.println(cifre[x]);
        }
    }
}