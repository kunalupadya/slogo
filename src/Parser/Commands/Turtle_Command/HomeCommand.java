package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class HomeCommand extends TurtleCommand {

    public HomeCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = Math.sqrt(Math.pow(turtle.getxPos(), 2) + Math.pow(turtle.getyPos(),2));
        turtle.moveTo(new Point(0,0));
    }
}
