package encryptdecrypt;

public abstract class Encoder extends AbstractEncoderDecoder {

    @Override
    public String cypher(CrypticMessage message) {
        return encode(message);
    }

    protected abstract String encode(CrypticMessage message);
}

class ShiftEncoder extends Encoder {

    @Override
    protected String encode(CrypticMessage message) {
        Cipher cipher = new ShiftCipher(message.key);// TODO push up Cipher construction

        return cipher.encode(message.inputData);
    }
}

class UnicodeEncoder extends Encoder {

    @Override
    protected String encode(CrypticMessage message) {
        Cipher cipher = new UnicodeCipher(message.key);// TODO push up Cipher construction

        return cipher.encode(message.inputData);
    }
}
