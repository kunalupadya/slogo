package Parser.Commands.Math;

import Parser.Commands.Command;

public class SumCommand implements Command {


    protected double execute(double a, double b){
        return a + b;
    }

    public int numParameters(){
        return 2;
    }
}
