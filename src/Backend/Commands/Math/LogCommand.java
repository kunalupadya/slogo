package Backend.Commands.Math;

import Backend.Commands.Command;

public class LogCommand implements Command {

    protected double execute(double a){
        return Math.log(a);
    }

    public int numParameters(){
        return 1;
    }
}
