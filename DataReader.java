package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {

    public static char[] getData(Input input) {
        if (input.data == null) {
            return getDataFromFile(input.in);
        }

        return input.data.toCharArray();
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
