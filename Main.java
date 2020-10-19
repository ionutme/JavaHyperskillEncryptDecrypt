package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        var input = new Input(args);

        char[] inputData = InOutController.read(input.data, input.in);
        CrypticMessage crypticMessage = CrypticMessage.create(inputData, input.key);

        var cipherProcessor = new CipherProcessor(input.mode, input.algorithm);
        String cyphertext = cipherProcessor.process(crypticMessage);

        InOutController.write(cyphertext, input.out);
    }
}
