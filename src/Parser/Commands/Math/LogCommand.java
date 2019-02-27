package Parser.Commands.Math;

import Parser.Commands.Command;

public class LogCommand implements Command {

    protected double execute(double a){
        return Math.log(a);
    }

    public int numParameters(){
        return 1;
    }
}
