package encryptdecrypt;

public class ShiftCipher extends UnicodeCipher {

    @Override
    protected char encode(char letter, int shiftedPos) {
        if (!Character.isLetter(letter)) {
            return letter;
        }

        char encodedLetter = super.encode(letter, shiftedPos);

        return encodedLetter <= 'z'
                    ? encodedLetter
                    : shiftFromBeginning(encodedLetter);
    }

    @Override
    protected char decode(char letter, int shiftedPos) {
        if (!Character.isLetter(letter)) {
            return letter;
        }

        char decodedLetter = super.decode(letter, shiftedPos);

        return decodedLetter >= 'a'
                    ? decodedLetter
                    : shiftFromTheEnd(decodedLetter);
    }

    private static char shiftFromBeginning(char letter) {
        int delta = letter - 'z';

        return (char) ('a' - 1 + delta);
    }

    private static char shiftFromTheEnd(char letter) {
        int delta = 'a' - letter;

        return (char) ('z' + 1 - delta);
    }
}
