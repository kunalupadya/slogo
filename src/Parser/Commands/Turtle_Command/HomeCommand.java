package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class HomeCommand extends TurtleCommand {

    public HomeCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController) {
        returnValue = Math.sqrt(Math.pow(getTurtle().getxPos(), 2) + Math.pow(getTurtle().getyPos(),2));
        getTurtle().moveTo(new Point(0,0));

    }
}
