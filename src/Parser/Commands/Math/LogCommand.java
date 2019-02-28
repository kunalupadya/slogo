package Parser.Commands.Math;

import Parser.Commands.Command;

public class LogCommand extends Command {

    protected double execute(double a){
        return Math.log(a);
    }

    public int getNumParameters(){
        return 1;
    }
}
