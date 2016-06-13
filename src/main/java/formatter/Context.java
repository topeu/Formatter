package formatter;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Context {
    private boolean offset;
    private int level;
    private char symbolForOffset;
    private int baseCountOffset;
    private char previousSymbol;
    public Context(String configPath) throws FormatterException{
        this.level = 0;
        this.offset = false;
        this.previousSymbol = 0;
        try {
            Properties config = new Properties();
            config.load(new FileInputStream(configPath));
            this.symbolForOffset = config.getProperty("offsetSymbol").charAt(0);
            this.baseCountOffset = Integer.parseInt(config.getProperty("baseCountOffset"));
        } catch (IOException e) {
            throw new FormatterException(e);
        }
    }
    public void setLevel(int lvl) {
        level = lvl;
    }

    public int getLevel() {
        return level;
    }

    public String createOffset() {
        char[] spaces = new char[getLevel() * baseCountOffset];
        Arrays.fill(spaces, symbolForOffset);
        return String.valueOf(spaces);
    }

    public boolean isOffset() {
        return offset;
    }

    public void setOffset(boolean offsetValue) {
        offset = offsetValue;
    }
    public void setPreviousSymbol(char symbol){previousSymbol = symbol;}
}

