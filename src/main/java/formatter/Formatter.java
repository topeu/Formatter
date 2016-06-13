package formatter;


import formatter.hander.CloseBraceHandler;
import formatter.hander.IHandler;
import formatter.hander.OpenBraceHandler;
import formatter.hander.SemicolonHandler;
import reader.IReader;
import reader.ReaderException;
import writer.IWriter;
import writer.WriterException;

import java.util.HashMap;

public class Formatter {
    private IReader source;
    private IWriter destination;
    private HashMap<Character,IHandler> lexeme;
    private Context context;
    public Formatter(IReader reader, IWriter writer,String configPath) throws FormatterException{
        this.source = reader;
        this.destination = writer;
        this.context = new Context(configPath);
        this.lexeme = new HashMap<>();
        lexeme.put(';', new SemicolonHandler(context));
        lexeme.put('{', new OpenBraceHandler(context));
        lexeme.put('}', new CloseBraceHandler(context));

    }

    public void format() throws FormatterException {

        try {
            while (source.hasNext()) {
                char symbol = source.read();
                if (lexeme.containsKey(symbol)) {
                    destination.write(lexeme.get(symbol).handle(symbol));
                } else {
                    if (context.isOffset()){
                        destination.write(context.createOffset());
                        context.setOffset(false);
                    }
                    context.setPreviousSymbol(symbol);
                    destination.write(String.valueOf(symbol));
                }
            }

        } catch (ReaderException | WriterException e) {
            throw new FormatterException(e);
        }

    }

}



