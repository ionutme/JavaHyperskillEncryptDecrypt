package encryptdecrypt;

public abstract class Decoder extends AbstractEncoderDecoder {

    Decoder(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String cypher(CrypticMessage message) {
        return decode(message);
    }

    protected abstract String decode(CrypticMessage message);
}

class ShiftDecoder extends Decoder {

    ShiftDecoder() {
        super(new ShiftCipher());
    }

    @Override
    protected String decode(CrypticMessage message) {
        return cipher.decode(message.inputData, message.key);
    }
}

class UnicodeDecoder extends Decoder {

    UnicodeDecoder() {
        super(new UnicodeCipher());
    }

    @Override
    protected String decode(CrypticMessage message) {
        return cipher.decode(message.inputData, message.key);
    }
}
