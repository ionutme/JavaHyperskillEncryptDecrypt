package encryptdecrypt;

public class CrypticMessage {
    final char[] inputData;
    final int key;

    private CrypticMessage(char[] inputData, int key) {
        this.inputData = inputData;
        this.key = key;
    }

    public static CrypticMessage create(char[] inputData, int key) {
        return new CrypticMessage(inputData, key);
    }
}
