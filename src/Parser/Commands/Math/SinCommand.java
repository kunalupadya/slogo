package Parser.Commands.Math;

import Parser.Commands.Command;

public class SinCommand implements Command {

    protected double execute(double a){
        return Math.cos(a);
    }

    public int numParameters(){
        return 1;
    }
}
