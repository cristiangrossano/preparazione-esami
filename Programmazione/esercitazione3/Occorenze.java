package esercitazione3;

import prog.io.*;

public class Occorenze {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        String input = in.readLine("Inserisci la striga da analizzare:      ");
        char carattere = in.readLine("inserisci il carattere da cercare:      ").charAt(0);

        out.println("La stringa e':  " + input);
        out.println("Il carattere da cercare e'':  " + carattere);

        int contatore = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == carattere)
                contatore++;
        }

        out.println("Il carattere si trova " + contatore + " volte nella stringa.");

    }
}
