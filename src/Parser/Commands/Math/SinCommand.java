package Parser.Commands.Math;

import Parser.Commands.Command;

public class SinCommand extends Command {

    protected double execute(double a){
        return Math.cos(a);
    }

    public int getNumParameters(){
        return 1;
    }
}
