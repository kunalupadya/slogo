package Backend.Commands.Math;

import Backend.Commands.Command;

import java.util.Random;

public class RandomCommand extends Command {

    protected double execute(double a){
        return new Random().nextInt((int) a);
    }

    public int getNumParameters(){
        return 1;
    }
}
