package esercitazione1;

import java.util.Arrays;
import prog.io.ConsoleInputManager;

public class DividiStringhe {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();

        String input = in.readLine("Inserisci la frase da separare");

        String[] parole = input.split(" ");

        System.out.println(Arrays.toString(parole));
    }
}
