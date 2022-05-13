package esercizio3;

import java.io.*;

public class ListDir {
	public static void main(String[] args) {

		File f = null;
		if (args.length == 0) {
			// directory corrente indicata dal punto
			f = new File(".");
		} else {
			f = new File(args[0]);
		}

		if (f.isFile()) {
			System.out.println("path =" + f.getAbsolutePath() + ", " + f.length());
		} else {
			File[] files = f.listFiles();

			System.out.println("I file sono: ");

			for (int i = 0; i < files.length; i++) {
				System.out.print("Pos." + (i + 1));
				System.out.println(files[i].getName());
			}
		}
	}
}
