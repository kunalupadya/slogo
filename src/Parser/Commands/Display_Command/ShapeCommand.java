package Parser.Commands.Display_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ShapeCommand extends TurtleCommand {

    public ShapeCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
       returnValue = getTurtle().getMyShape();
    }
}
