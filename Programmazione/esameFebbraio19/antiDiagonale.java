package esameFebbraio19;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Impossibile extends Exception {

    public Impossibile(String message) {
        super(message);
    }
}

public class antiDiagonale {

    public static int[] getAntidiagonale(int matrix[][]) throws Impossibile {
        if (matrix.length != matrix[0].length) {
            throw new Impossibile("la matrice non e’ quadrata");
        }
        int[] antidiagonale = new int[matrix.length];

        for (int p = 0; p < antidiagonale.length; p++) {
            antidiagonale[p] = matrix[p][(matrix.length - 1) - p];
        }
        return antidiagonale;
    }

    public static void main(String[] args) throws Impossibile {
        Random generatore = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci altezza della matrice: ");
        int altezza = scanner.nextInt();
        System.out.print("Inserisci lunghezza della matrice: ");
        int lunghezza = scanner.nextInt();

        int[][] matrici = new int[altezza][lunghezza];

        for (int x = 0; x < matrici.length; x++) {
            for (int y = 0; y < matrici[x].length; y++) {
                matrici[x][y] = generatore.nextInt(9);
            }
        }

        System.out.print("\n");

        // Scrive la matrice per intero
        for (int j = 0; j < matrici.length; j++) {
            System.out.println(Arrays.toString(matrici[j]));
        }
        // ------------

        System.out.println("\n" + Arrays.toString(getAntidiagonale(matrici)));

        scanner.close();
    }
}