package Backend.Commands.Math;

import Backend.Commands.Command;

public class RemainderCommand extends Command {

    protected double execute(double a, double b){
        return a%b;
    }

    public int getNumParameters(){
        return 2;
    }
}
