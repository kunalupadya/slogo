package Parser.Commands.Math;

import Parser.Commands.Command;

public class AtanCommand extends Command {

    protected double execute(double a){
        return Math.atan(a);
    }

    public int getNumParameters(){
        return 1;
    }
}
