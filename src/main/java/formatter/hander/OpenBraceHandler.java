package formatter.hander;

import formatter.Context;

public class OpenBraceHandler implements IHandler {
    private Context context;
    public OpenBraceHandler(Context context){
        this.context = context;
    }
    @Override
    public String handle(char symbol) {
        context.setLevel(context.getLevel()+1);
        return String.valueOf(symbol) + "\n" + context.createOffset();
    }
}
