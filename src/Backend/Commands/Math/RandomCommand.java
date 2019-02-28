package Backend.Commands.Math;

import Backend.Commands.Command;

import java.util.Random;

public class RandomCommand implements Command {

    protected double execute(double a){
        return new Random().nextInt((int) a);
    }

    public int numParameters(){
        return 1;
    }
}
