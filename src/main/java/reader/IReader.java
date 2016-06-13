package reader;


public interface IReader  {
    char read() throws ReaderException;
    boolean hasNext() throws ReaderException;
}
