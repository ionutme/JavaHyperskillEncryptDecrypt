package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        InOutController inout = new InOutController(args);

        CipherProcessor processor = new CipherProcessor(inout.input.mode, inout.input.algorithm);
        String cyphertext = processor.process(CrypticMessage.create(inout));

        inout.write(cyphertext);
    }
}
