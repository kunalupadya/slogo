package Parser.Commands.Display_Command;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetPenColorCommand extends TurtleCommand {

    public SetPenColorCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
//        (getTurtle().getMyPen().setPenColor(getChildren().get(0).getReturnValue() (int));
    }
}
