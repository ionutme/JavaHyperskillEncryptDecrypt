package encryptdecrypt;

public abstract class Decoder extends AbstractEncoderDecoder {

    @Override
    public String cypher(CrypticMessage message) {
        return decode(message);
    }

    protected abstract String decode(CrypticMessage message);
}

class ShiftDecoder extends Decoder {

    @Override
    protected String decode(CrypticMessage message) {
        Cipher cipher = new ShiftCipher(message.key);// TODO push up Cipher construction

        return cipher.decode(message.inputData);
    }
}

class UnicodeDecoder extends Decoder {

    @Override
    protected String decode(CrypticMessage message) {
        Cipher cipher = new UnicodeCipher(message.key);// TODO push up Cipher construction

        return cipher.decode(message.inputData);
    }
}
