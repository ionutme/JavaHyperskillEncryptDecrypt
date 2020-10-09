package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InOutController {
    public final Input input;

    InOutController(String[] args) {
        this.input = new Input(args);
    }

    public char[] read() {
        return DataReader.getData(this.input);
    }

    public void write(String text) {
        String outputFilename = getOutputFilename();
        if (getOutputFilename() != null) {
            try (var dataWriter = new DataWriter(outputFilename)) {
                dataWriter.write(text);
            } catch (FileNotFoundException exception) {
                System.out.println("File not found!");
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private String getOutputFilename() {
        return this.input.out;
    }
}
