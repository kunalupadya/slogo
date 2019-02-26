package Parser.Commands.Math;

public class CosCommand extends MathCommand{

    protected double execute(double a){
        return Math.cos(a);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
