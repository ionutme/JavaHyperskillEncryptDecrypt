package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        var input = new Input(args);
        char[] inputData = InOutController.read(input.data, input.in);
        var crypticMessage = CrypticMessage.create(inputData, input.key);

        var processor = new CipherProcessor(input.mode, input.algorithm);
        String cyphertext = processor.process(crypticMessage);

        InOutController.write(cyphertext, input.out);
    }
}
