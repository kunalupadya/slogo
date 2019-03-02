package Parser.Commands.Display_Command;

import Parser.Commands.TurtleCommand;

public class PenColorCommand extends TurtleCommand {

    public PenColorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        returnValue = getTurtle().getMyPen().getPenColor();
    }


}

