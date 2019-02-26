package Parser.Commands.Math;

import Parser.Commands.Command;

public class AtanCommand implements Command {

    protected double execute(double a){
        return Math.atan(a);
    }

    protected int numParameters(){
        return 1;
    }
}
