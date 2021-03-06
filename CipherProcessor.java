package encryptdecrypt;

public class CipherProcessor {

    private final AbstractEncoderDecoder processor;

    CipherProcessor(String mode, String type) {
        this.processor = getEncoderDecoder(mode, type);
    }

    public String process(CrypticMessage message) {
        return processor.cypher(message);
    }

    private AbstractEncoderDecoder getEncoderDecoder(String mode, String type) {
        EncoderDecoderFactory factory = getEncoderDecoderFactory(mode);

        return factory.create(type);
    }

    private EncoderDecoderFactory getEncoderDecoderFactory(String type) {

        EncoderDecoderFactory factory;
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
