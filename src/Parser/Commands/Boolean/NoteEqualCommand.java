package Parser.Commands.Boolean;

public class NoteEqualCommand extends BooleanCommand{

    protected double execute(double a){
        return returnValue(a!=0);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
