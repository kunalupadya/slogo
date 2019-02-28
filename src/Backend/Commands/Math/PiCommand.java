package Backend.Commands.Math;

import Backend.Commands.Command;

public class PiCommand extends Command {

    public double execute(){
        return Math.PI;
    }

    public int numParameters(){
        return 0;
    }
}
