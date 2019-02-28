package Backend.Commands.Math;

import Backend.Commands.Command;

public class CosCommand extends Command {

    protected double execute(double a){
        return Math.cos(a);
    }

    public int getNumParameters(){
        return 1;
    }
}
