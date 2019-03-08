package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetPositionCommand extends TurtleCommand{

    public SetPositionCommand(){
        isConstant = false;
        numParameters = 2;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        returnValue =  distance(turtle.getPos(),newPos);
        turtle.moveTo(newPos);
    }

    @Override
    public Command copy() {
        return new SetPositionCommand();
    }
}
