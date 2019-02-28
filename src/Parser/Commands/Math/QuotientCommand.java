package Parser.Commands.Math;

import Parser.Commands.Command;

public class QuotientCommand extends Command {

    protected double execute(double a, double b){
        return a/b;
    }

    public int getNumParameters(){
        return 2;
    }
}