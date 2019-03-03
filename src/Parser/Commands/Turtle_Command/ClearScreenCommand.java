package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class ClearScreenCommand extends TurtleCommand {

    public ClearScreenCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                returnValue = Math.sqrt(Math.pow(getTurtle().getxPos(), 2) + Math.pow(getTurtle().getyPos(), 2));
                getTurtle().moveTo(new Point(0, 0));
            }
        }
    }

}
