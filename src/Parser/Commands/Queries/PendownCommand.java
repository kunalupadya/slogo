package Parser.Commands.Queries;

import Parser.Commands.TurtleCommand;

public class PendownCommand extends TurtleCommand {

    public PendownCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void execute(){
        if (getTurtle().getMyPen().getPenUp()){
            returnValue = 1;
        }
        else returnValue = 0;
    }

}
