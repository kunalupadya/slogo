package Parser.Commands.Math;

import Parser.Commands.Command;

public class PowCommand extends Command {

    protected double execute(double a, double b){
        return Math.pow(a,b);
    }

    public int getNumParameters(){
        return 2;
    }

}
