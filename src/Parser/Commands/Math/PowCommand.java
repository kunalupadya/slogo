package Parser.Commands.Math;

import Parser.Commands.Command;

public class PowCommand implements Command {

    protected double execute(double a, double b){
        return Math.pow(a,b);
    }

    protected int numParameters(){
        return 2;
    }

}
