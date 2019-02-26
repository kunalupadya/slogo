package Parser.Commands.Boolean;

public class NotCommand extends BooleanCommand{

    protected double execute(double a){
        return returnValue(a == 0);
    }

    protected int numParameters(){
        return 1;
    }
}
