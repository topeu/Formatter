import formatter.Formatter;
import formatter.FormatterException;
import reader.FileReader;
import reader.ReaderException;
import writer.FileWriter;
import writer.StringWriter;
import writer.WriterException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ReaderException, WriterException, FormatterException {
        try {
            // StringReader stringReader = new StringReader("while   (iReader.hasNext())              {char ch = iReader.read();buffer.append(ch);if (ch=='a'){iWriter.write(buffer.toString().trim() + \"\\n\");buffer.delete(0,buffer.length());} str.balance;}");
            FileWriter fileWriter = new FileWriter(new FileOutputStream("output.txt"));
            FileReader fileReader = new FileReader(new FileInputStream("input.txt"));
            String string = "";
            StringWriter stringWriter = new StringWriter(string);
            Formatter formatter = new Formatter(fileReader,fileWriter,"config.properties");
            formatter.format();
            System.out.println(stringWriter.toString());


        } catch (IOException e) {
            System.out.println("mb file not found");
        }

    }
}
