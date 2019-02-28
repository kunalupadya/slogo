package Backend.Commands.Math;

import Backend.Commands.Command;

public class CosCommand implements Command {

    protected double execute(double a){
        return Math.cos(a);
    }

    public int numParameters(){
        return 1;
    }
}
