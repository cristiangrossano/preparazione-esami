package esercitazione4;

import prog.io.*;

public class Divisione {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        while (true) {
            int numero = in.readInt("Inserisci un numero:        ");
            int denominatore = (int) (Math.random() * 4);

            try {
                System.out.printf("%d / %d = ", numero, denominatore);
                System.out.println(numero / denominatore);
            } catch (ArithmeticException e) {
                out.println("Non è possibile dividere un numero per zero");
            }

        }
    }
}
