package Parser.Commands.Math;

public class LogCommand extends MathCommand{

    protected double execute(double a){
        return Math.log(a);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
