package encryptdecrypt;

public abstract class AbstractEncoderDecoder {
    protected final Cipher cipher;

    AbstractEncoderDecoder(Cipher cipher) {
        this.cipher = cipher;
    }

    abstract String cypher(CrypticMessage message);
}
