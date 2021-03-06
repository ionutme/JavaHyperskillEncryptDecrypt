package encryptdecrypt;

public abstract class EncoderDecoderFactory {

    abstract AbstractEncoderDecoder create(String type);
}

class EncoderFactory extends EncoderDecoderFactory {

    @Override
    AbstractEncoderDecoder create(String type) {
        Encoder encoder;
        switch (type.toUpperCase()) {
            case "SHIFT":
                encoder = new ShiftEncoder();
                break;
            case "UNICODE":
                encoder = new UnicodeEncoder();
                break;
            default:
                encoder = null;
                break;
        }

        return encoder;
    }
}

class DecoderFactory extends EncoderDecoderFactory {

    @Override
    AbstractEncoderDecoder create(String type) {
        Decoder decoder;
        switch (type.toUpperCase()) {
            case "SHIFT":
                decoder = new ShiftDecoder();
                break;
            case "UNICODE":
                decoder = new UnicodeDecoder();
                break;
            default:
                decoder = null;
                break;
        }

        return decoder;
    }
}
