package Backend.Commands.Boolean;


public class EqualCommand extends BooleanCommand{

    public double execute(double a, double b){
        return returnValue(a == b);
    }

    public int getNumParameters(){
        return 2;
    }
}
