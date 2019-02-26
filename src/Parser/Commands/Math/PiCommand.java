package Parser.Commands.Math;

import Parser.Commands.Command;

public class PiCommand implements Command {

    protected double execute(){
        return Math.PI;
    }

    protected int numParameters(){
        return 0;
    }
}
