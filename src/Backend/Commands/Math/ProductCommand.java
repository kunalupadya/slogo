package Backend.Commands.Math;

import Backend.Commands.Command;

public class ProductCommand implements Command {


    protected double execute(double a, double b){
        return a*b;
    }

    public int numParameters(){
        return 2;
    }
}
