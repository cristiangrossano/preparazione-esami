package esercizio2;

import java.io.*;

public class CopiaFile {
	public static void main(String[] args) throws IOException {
		if (args.length == 2) {
			FileReader frd = new FileReader(args[0]);
			FileWriter fwr = new FileWriter(args[1]);

			// un carattere alla volta
			int elementoLettoScritto;

			while ((elementoLettoScritto = frd.read()) != -1) {
				System.out.print((char) elementoLettoScritto);
				fwr.write(elementoLettoScritto);
			}

			frd.close();
			fwr.flush();
			fwr.close();
		} else {
			System.out.println("Dammi i nomi dei file.");
		}
	}
}