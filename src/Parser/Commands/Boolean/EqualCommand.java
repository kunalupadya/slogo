package Parser.Commands.Boolean;


public class EqualCommand extends BooleanCommand {

    protected double execute(double a, double b){
        return returnValue(a == b);
    }

    @Override
    protected int numParameters(){
        return 2;
    }
}
