package Parser.Commands.Math;

import Parser.Commands.Command;

public class TanCommand implements Command {


    protected double execute(double a){
        return Math.tan(a);
    }
    
    public int numParameters(){
        return 1;
    }
}
