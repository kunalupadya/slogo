package Parser.Commands.Math;

public class AtanCommand extends MathCommand {

    protected double execute(double a){
        return Math.atan(a);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
