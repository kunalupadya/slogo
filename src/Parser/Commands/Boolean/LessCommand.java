package Parser.Commands.Boolean;

public class LessCommand extends BooleanCommand {

    protected double execute(double a, double b){
        return returnValue(a < b );
    }

    public int numParameters(){
        return 2;
    }
}
