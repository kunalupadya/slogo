package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetXYCommand extends TurtleCommand{

    public SetXYCommand(){
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        returnValue =  distance(turtle.getPos(),newPos);
        turtle.moveTo(newPos);
    }
}
