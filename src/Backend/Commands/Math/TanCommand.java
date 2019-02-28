package Backend.Commands.Math;

import Backend.Commands.Command;

public class TanCommand extends Command {


    protected double execute(double a){
        return Math.tan(a);
    }
    
    public int getNumParameters(){
        return 1;
    }
}
