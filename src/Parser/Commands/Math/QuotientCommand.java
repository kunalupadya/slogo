package Parser.Commands.Math;

public class QuotientCommand extends MathCommand {

    protected double execute(double a, double b){
        return a/b;
    }

    @Override
    protected int numParameters(){
        return 2;
    }
}
