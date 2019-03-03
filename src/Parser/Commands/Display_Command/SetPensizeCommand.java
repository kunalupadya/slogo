package Parser.Commands.Display_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetPensizeCommand extends TurtleCommand {


    public SetPensizeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        getTurtle().getMyPen().setPenSize((int)getChildren().get(0).getReturnValue());
    }
}
