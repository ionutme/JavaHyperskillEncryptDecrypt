package encryptdecrypt;

public class UnicodeCipher extends Cipher {

    @Override
    protected char encode(char letter, int shiftedPos) {
        return (char) (letter + shiftedPos);
    }

    @Override
    protected char decode(char letter, int shiftedPos) {
        return (char) (letter - shiftedPos);
    }
}

