package Backend.Commands.Math;

import Backend.Commands.Command;

public class DifferenceCommand implements Command {

    protected double execute(double a, double b){
        return Math.abs(a - b);
    }

    public int numParameters(){
        return 2;
    }
}
