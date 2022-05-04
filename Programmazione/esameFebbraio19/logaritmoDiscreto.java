package esameFebbraio19;

import prog.io.ConsoleInputManager;

public class logaritmoDiscreto {

    public static int log(int n) {
        int contatore = 0;
        if (n < 1)
            return contatore;

        int potenza = 1;

        do {
            potenza = potenza * 2;
            contatore = contatore + 1;

        } while (n >= potenza);

        return contatore - 1;
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        int numero = in.readInt("Inserisci numero!   \n");

        System.out.println(log(numero));
    }
}
