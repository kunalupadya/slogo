package Backend.Commands.Math;

import Backend.Commands.Command;

public class PiCommand implements Command {

    protected double execute(){
        return Math.PI;
    }

    public int numParameters(){
        return 0;
    }
}
