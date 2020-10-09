package encryptdecrypt;

public class UnicodeCipher extends Cipher {
    UnicodeCipher(int key) {
        super(key);
    }

    @Override
    protected char encode(char letter, int shiftedPos) {
        return (char) (letter + shiftedPos);
    }

    @Override
    protected char decode(char letter, int shiftedPos) {
        return (char) (letter - shiftedPos);
    }
}

