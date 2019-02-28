package Parser.Commands.Math;

import Parser.Commands.Command;

public class DifferenceCommand extends Command {

    protected double execute(double a, double b){
        return Math.abs(a - b);
    }

    public int getNumParameters(){
        return 2;
    }
}
