package Parser.Commands.Math;

public class PowCommand extends MathCommand{

    protected double execute(double a, double b){
        return Math.pow(a,b);
    }

    @Override
    protected int numParameters(){
        return 2;
    }

}
