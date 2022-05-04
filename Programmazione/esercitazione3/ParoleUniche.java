package esercitazione3;

import java.util.*;
import prog.io.*;

public class ParoleUniche {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();

        String s = in.readLine("Inserisci la stringa da analizzare");

        List<String> words = Arrays.asList(s.split(" "));
        Set<String> paroleUniche = new HashSet<String>(words);

        System.out.printf("Occorrenze uniche trovate in \n");
        System.out.println(s);
        for (String w : paroleUniche) {
            System.out.println(w);
        }
    }
}
