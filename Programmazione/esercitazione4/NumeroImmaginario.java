package esercitazione4;

import prog.io.*;

public class NumeroImmaginario {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        double reale, immaginario;

        for (int i = 0; i < 3; i++) {
            String s = in
                    .readLine("Inserisci un numero reale o immaginario, il numero immaginario è preceduto da una j");
            try {
                reale = Double.parseDouble(s);
                out.print("Numero reale:    " + reale);

            } catch (NumberFormatException e) {
                if (s.charAt(0) == 'j') {
                    try {
                        immaginario = Double.parseDouble(s.substring(1, s.length()));
                        out.println("Numero immaginario:    " + immaginario);
                    } catch (NumberFormatException err) {
                        out.println("Impossibile");
                    }
                } else
                    out.println("Impossibile!");
            }
        }
    }
}
