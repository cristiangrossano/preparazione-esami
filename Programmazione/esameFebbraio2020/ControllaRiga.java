package esameFebbraio2020;

import java.util.Scanner;
import java.util.Vector;

public class ControllaRiga {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vector<String> stringhe = new Vector<String>();
        String input;

        while ((input = in.nextLine()).length() > 0) {
            boolean f = false;

            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    f = true;
                    break;
                }
            }

            if (Character.isUpperCase(input.charAt(input.length() - 1)))
                f = true;

            if (!f)
                stringhe.add(input);
        }

        System.out.println(stringhe);

        for (int i = 0; i < stringhe.size(); i += 1)
            System.out.println(stringhe.get(i));

            in.close();
    }
}