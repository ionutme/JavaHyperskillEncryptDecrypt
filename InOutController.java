package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InOutController {
    public static char[] read(String inputData, String filename) {
        return DataReader.getData(inputData, filename);
    }

    public static void write(String text, String filename) {
        if (filename == null) {
            System.out.println(text);
            return;
        }

        try (var dataWriter = new DataWriter(filename)) {
            dataWriter.write(text);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
