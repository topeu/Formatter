package reader;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReader implements IReader, AutoCloseable {
    private FileInputStream fileInputStream;
    private int streamAvailable;
    private int symbolNumber;

    public FileReader(FileInputStream in) throws ReaderException {
        try {
            this.fileInputStream = in;
            this.streamAvailable = fileInputStream.available();
            this.symbolNumber = 0;
        } catch (IOException e) {
            throw new ReaderException(e);
        }

    }

    public char read() throws ReaderException {
        try {
            int symbol = fileInputStream.read();
            symbolNumber++;
            return (char) symbol;
        } catch (IOException e) {
            throw new ReaderException(e);
        }


    }


    @Override
    public void close() throws Exception {
        fileInputStream.close();

    }

    @Override
    public boolean hasNext() {
        return symbolNumber != streamAvailable;

    }
}
