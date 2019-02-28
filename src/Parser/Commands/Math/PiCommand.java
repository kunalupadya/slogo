package Parser.Commands.Math;

import Parser.Commands.Command;

public class PiCommand extends Command {

    public double execute(){
        return Math.PI;
    }

    public int numParameters(){
        return 0;
    }
}
