package encryptdecrypt;

public class CipherProcessor {

    private final AbstractEncoderDecoder processor;

    CipherProcessor(String mode, String type) {
        this.processor = getCipher(mode, type);
    }

    public String process(CrypticMessage message) {
        return processor.cypher(message);
    }

    private AbstractEncoderDecoder getCipher(String mode, String type) {
        CipherFactory factory = getCipherFactory(mode);

        return factory.create(type);
    }

    private CipherFactory getCipherFactory(String type) {

        CipherFactory factory;
        switch (type.toUpperCase()) {
            case "ENC":
                factory = new EncoderFactory();
                break;
            case "DEC":
                factory = new DecoderFactory();
                break;
            default:
                factory = null;
                break;
        }

        return factory;
    }
}