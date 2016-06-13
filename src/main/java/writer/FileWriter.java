package writer;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter implements IWriter {
    private FileOutputStream fileoutputStream;

    public FileWriter(FileOutputStream out) {
        this.fileoutputStream = out;
    }


    public void write(String inString) throws WriterException {
        try {
            char[] sToCharArr = inString.toCharArray();
            for (int i = 0; i < inString.length(); i++) {
                fileoutputStream.write(sToCharArr[i]);
            }
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }


    public void close() throws WriterException{
        try {
            fileoutputStream.close();
        } catch (IOException e){
            throw new WriterException(e);
        }
    }
}
