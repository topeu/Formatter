package formatter.handler;


import formatter.Context;

public class CloseBraceHandler implements IHandler {
    private Context context;
    public CloseBraceHandler(Context context){
        this.context = context;
    }
    public String handle(char symbol) {
        context.setPreviousSymbol(symbol);
        context.setLevel(context.getLevel() - 1);
        return context.createOffset() + String.valueOf(symbol) + "\n";
    }
}
