package Backend.Commands.Math;

import Backend.Commands.Command;

public class AtanCommand implements Command {

    protected double execute(double a){
        return Math.atan(a);
    }

    public int numParameters(){
        return 1;
    }
}
