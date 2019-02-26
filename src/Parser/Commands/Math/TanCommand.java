package Parser.Commands.Math;

public class TanCommand extends MathCommand {


    protected double execute(double a){
        return Math.tan(a);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
