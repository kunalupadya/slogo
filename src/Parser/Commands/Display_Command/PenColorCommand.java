package Parser.Commands.Display_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class PenColorCommand extends TurtleCommand {

    public PenColorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
//        returnValue = getTurtle().getMyPen().getPenColor();
    }


}

