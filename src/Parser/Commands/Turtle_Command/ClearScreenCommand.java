package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ClearScreenCommand extends TurtleCommand {

    public ClearScreenCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction(){
        returnValue = Math.sqrt(Math.pow(getTurtle().getxPos(), 2) + Math.pow(getTurtle().getyPos(),2));
        getTurtle().moveTo(new Point(0,0));
    }

}
