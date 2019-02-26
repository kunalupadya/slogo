package Parser.Commands.Math;

public class DifferenceCommand extends MathCommand{

    protected double execute(double a, double b){
        return Math.abs(a - b);
    }

    @Override
    protected int numParameters(){
        return 2;
    }
}
