package encryptdecrypt;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter implements Closeable {
    final FileWriter fileWriter;

    DataWriter() {
        this.fileWriter = null;
    }

    DataWriter(String filename) throws IOException {
        this.fileWriter = new FileWriter(filename);
    }

    public void write(String text) {
        if (this.fileWriter != null) {
            try {
                this.fileWriter.write(text);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println(text);
    }

    @Override
    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
