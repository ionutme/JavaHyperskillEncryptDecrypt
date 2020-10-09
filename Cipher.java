package encryptdecrypt;

@FunctionalInterface
interface CipherFunc {
    char apply(char letter, int key);
}

public abstract class Cipher {
    private final int key;

    Cipher(int key) {
        this.key = key;
    }

    public String encode(char[] letters) {
        return cypher(letters, this.key, this::encode);
    }

    public String decode(char[] letters) {
        return cypher(letters, this.key, this::decode);
    }

    protected abstract char encode(char letter, int shiftedPos);

    protected abstract char decode(char letter, int shiftedPos);

    private static String cypher(char[] letters, int key, CipherFunc func) {
        var cypheredChars = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            cypheredChars[i] = func.apply(letters[i], key);
        }

        return String.valueOf(cypheredChars);
    }
}
