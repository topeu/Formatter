package reader;

public class StringReader implements IReader {
    private int symbolNumber;
    private String str;

    public StringReader(String string) {
       this.str=string;
        this.symbolNumber =0;

    }



    @Override
    public char read() {
        char symbol = str.charAt(symbolNumber);
        symbolNumber++;
        return symbol;

    }

    @Override
    public boolean hasNext() {
        return symbolNumber != str.length();
    }
}


