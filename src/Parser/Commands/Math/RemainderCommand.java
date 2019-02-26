package Parser.Commands.Math;

import Parser.Commands.Command;

public class RemainderCommand implements Command {

    protected double execute(double a, double b){
        return a%b;
    }

    protected int numParameters(){
        return 2;
    }
}
