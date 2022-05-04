package esercitazione2;
import java.util.Random;
import prog.io.*;

public class ArrayCasuale {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int dimensione = in.readInt("Inserisci la dimensione desiderata per l'array     ");
        int valmax = in.readInt("Inserisci il valore negati/positivo massimo        ");
        int[] array = new int[dimensione];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            boolean segno = random.nextBoolean();
            array[i] = random.nextInt(valmax);
            if (segno == false)
                array[i] = array[i] * -1;
        }

        String output = "";
        String separa = " , ";

        for (int x = 0; x < array.length; x++) {
            output = output + array[x] + separa;
        }

        out.println("[" + output + "]");
    }
}
