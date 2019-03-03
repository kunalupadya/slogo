package Parser.Commands.Display_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetShapeCommand extends TurtleCommand {

    public SetShapeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
       getTurtle().setMyShape((int)getChildren().get(0).getReturnValue());
    }
}
