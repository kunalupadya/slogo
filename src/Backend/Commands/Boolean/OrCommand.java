package Backend.Commands.Boolean;

public class OrCommand extends BooleanCommand {

    protected double execute(double a, double b){
        return returnValue(a != 0 || b !=0);
    }

    public int numParameters(){
        return 2;
    }
}
