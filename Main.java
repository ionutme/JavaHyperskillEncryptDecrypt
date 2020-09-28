package encryptdecrypt;

@FunctionalInterface
interface CypherFunc {
    char apply(char letter, int key);
}

public class Main {
    public static void main(String[] args) {
        String mode = extract(args, "MODE", "enc");
        int key = Integer.parseInt(extract(args, "KEY", "0"));
        String message = extract(args, "DATA", "");

        String cyphertext = getCypheredMessage(message.toCharArray(), key, mode);

        System.out.println(cyphertext);
    }

    private static String extract(String[] args, String arg, String defaultValue) {
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].substring(1).toLowerCase().equals(arg.toLowerCase())) {
                return args[i + 1];
            }
        }

        return defaultValue;
    }

    private static String getCypheredMessage(char[] letters, int key, String mode) {
        String cyphertext;
        switch (mode.toUpperCase()) {
            case "DEC":
                cyphertext = getCypheredMessage(letters, key, Main::decrypt);
                break;
            case "ENC":
                cyphertext = getCypheredMessage(letters, key, Main::encrypt);
                break;
            default:
                cyphertext = null;
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
        return (char) (letter + shiftedPos);
    }

    private static char decrypt(char letter, int shiftedPos) {
        return (char) (letter - shiftedPos);
    }
}
