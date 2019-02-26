package Parser.Commands.Math;

public class PiCommand extends MathCommand{

    protected double execute(){
        return Math.PI;
    }

    @Override
    protected int numParameters(){
        return 0;
    }
}
