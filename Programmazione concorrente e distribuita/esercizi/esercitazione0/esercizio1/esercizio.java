package esercizio1;

import java.io.*;

public class esercizio {
	BufferedReader br;

	/*
	 * Se nel main vogliamo usare funzioni non statiche chiamiamo un altro metodo
	 */
	int n = 0;

	esercizio() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	esitoLettura leggiInt() {
		String s;
		try {
			s = br.readLine();
		} catch (IOException e) {
			return esitoLettura.ErroreIO;

		}
		if (s.toLowerCase().equals("basta")) {
			return esitoLettura.LettoEOF;
		}
		try {
			n = Integer.parseInt(s);
			return esitoLettura.LettoNum;
		} catch (NumberFormatException e) {
			System.out.println("Non � un numero.");
			return esitoLettura.LettoBoh;
		}
	}

	void exec() {
		boolean finito = false;

		while (!finito) {
			System.out.print("Insersci Numero > ");
			esitoLettura el = leggiInt();

			// più di una possibilità quindi facciamo uno switch
			switch (el) {
			// lettura di un numero
			case LettoNum:
				System.out.println("Hai inserito " + n);
				break;

			// basta = fine processo
			case LettoEOF:
				finito = true;
				break;

			// lettura valore non numero
			case LettoBoh:
				System.out.println("Non è un numero.");
				break;

			// errore
			case ErroreIO:
				System.out.println("Errore di IO, Chiusura Processo");
				finito = true;
				break;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// esecuzione del metodo exec
		esercizio tt = new esercizio();
		tt.exec();
	}
}
