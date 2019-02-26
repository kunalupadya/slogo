package Parser.Commands.Math;

import java.util.Random;

public class RandomCommand extends MathCommand{

    protected double execute(double a){
        return new Random().nextInt((int) a);
    }

    @Override
    protected int numParameters(){
        return 1;
    }
}
