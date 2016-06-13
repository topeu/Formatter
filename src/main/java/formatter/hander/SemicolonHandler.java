package formatter.hander;

import formatter.Context;

public class SemicolonHandler implements IHandler {
    private Context context;
    public SemicolonHandler(Context context){
        this.context = context;
    }
    @Override
    public String handle(char symbol) {
        context.setOffset(true);
        return String.valueOf(symbol) + "\n";
    }
}
