package encryptdecrypt;

public abstract class Encoder extends AbstractEncoderDecoder {

    Encoder(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String cypher(CrypticMessage message) {
        return encode(message);
    }

    protected abstract String encode(CrypticMessage message);
}

class ShiftEncoder extends Encoder {

    ShiftEncoder() {
        super(new ShiftCipher());
    }

    @Override
    protected String encode(CrypticMessage message) {
        return cipher.encode(message.inputData, message.key);
    }
}

class UnicodeEncoder extends Encoder {

    UnicodeEncoder() {
        super(new UnicodeCipher());
    }

    @Override
    protected String encode(CrypticMessage message) {
        return cipher.encode(message.inputData, message.key);
    }
}
