package Parser.Commands.Queries;

import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class HeadingCommand extends TurtleCommand {

    public HeadingCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        returnValue = myTurtle.getMyAngle();

    }
}
