package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {

    public static char[] getData(String inputData, String filename) {
        if (inputData == null) {
            return getDataFromFile(filename);
        }

        return inputData.toCharArray();
    }

    private static char[] getDataFromFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename))).toCharArray();
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
