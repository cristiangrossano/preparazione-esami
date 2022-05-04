package Gennaio20;

import prog.io.*;

public class Contalettere {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        String frase = in.readLine("Inserisci la stringa:  ");
        int[] n = new int['z' - 'a' + 1];

        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i));
            if (c <= 'z' && c >= 'a') {
                n[c - 'a']++;

            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++)
            out.println("numero di occorrenze di " + ch + ": " + n[ch - 'a']);
    }
}
