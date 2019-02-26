package Parser.Commands.Boolean;

public class AndCommand extends BooleanCommand{

    protected double execute(double a, double b){
        return returnValue(a != 0 && b !=0);
    }

    @Override
    protected int numParameters(){
        return 2;
    }
}
