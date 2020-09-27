package encryptdecrypt;

import java.util.Scanner;

@FunctionalInterface
interface CypherFunc {
    public char apply(char letter, int key);
}

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        String mode = input.nextLine();
        String message = input.nextLine();
        int key = input.nextInt();

        String cyphertext = getCypheredMessage(message.toCharArray(), key, mode);

        System.out.println(cyphertext);
    }

    private static String getCypheredMessage(char[] letters, int key, String mode) {
        String cyphertext = null;
        switch (mode.toUpperCase()) {
            case "ENC":
                cyphertext = getCypheredMessage(letters, key, Main::encrypt);
            break;
            case "DEC":
                cyphertext = getCypheredMessage(letters, key, Main::decrypt);
            break;
        }
        return cyphertext;
    }

    private static String getCypheredMessage(char[] letters, int key, CypherFunc func) {
        var encryptedChars = new char[letters.length];

        for (int i = 0; i < letters.length; i++) {
            encryptedChars[i] = func.apply(letters[i], key);
        }

        return String.valueOf(encryptedChars);
    }

    private static char encrypt(char letter, int shiftedPos) {
        char encryptedLetter = (char) (letter + shiftedPos);
        /*if (encryptedLetter > 'z') {
            int delta = encryptedLetter - 'z';
            encryptedLetter = (char) ('a' - 1 + delta);
        }*/

        return encryptedLetter;
    }

    private static char decrypt(char letter, int shiftedPos) {
        char encryptedLetter = (char) (letter - shiftedPos);

        return encryptedLetter;
    }
}
