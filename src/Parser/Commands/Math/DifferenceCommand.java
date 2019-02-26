package Parser.Commands.Math;

import Parser.Commands.Command;

public class DifferenceCommand implements Command {

    protected double execute(double a, double b){
        return Math.abs(a - b);
    }

    protected int numParameters(){
        return 2;
    }
}
