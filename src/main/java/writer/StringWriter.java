package writer;


public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    public StringWriter(String outString){
        this.stringBuilder = new StringBuilder(outString);
    }

    public void write(String addString) throws WriterException {
        stringBuilder.append(addString);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
