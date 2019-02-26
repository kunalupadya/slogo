package Parser.Commands.Math;

import Parser.Commands.Command;

import java.util.Random;

public class RandomCommand implements Command {

    protected double execute(double a){
        return new Random().nextInt((int) a);
    }

    protected int numParameters(){
        return 1;
    }
}
