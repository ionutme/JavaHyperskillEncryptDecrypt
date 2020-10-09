package encryptdecrypt;

public class ShiftCipher extends UnicodeCipher {

    ShiftCipher(int key) {
        super(key);
    }

    @Override
    protected char encode(char letter, int shiftedPos) {
        var encodedLetter = super.encode(letter, shiftedPos);
        if (encodedLetter > 'z') {
            int delta = encodedLetter - 'z';
            encodedLetter = (char) ('a' - 1 + delta);
        }

        return encodedLetter;
    }

    @Override
    protected char decode(char letter, int shiftedPos) {
        var encodedLetter = super.decode(letter, shiftedPos);
        if (encodedLetter < 'a') {
            int delta = 'a' - encodedLetter;
            encodedLetter = (char) ('z' + 1 - delta);
        }

        return encodedLetter;
    }
}
