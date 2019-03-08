package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ClearScreenCommand extends TurtleCommand {

    public ClearScreenCommand(){
        isConstant = false;
        numParameters = 0;
    }

    protected void turtleAction(Turtle turtle) {
        returnValue = distance(new Point(0,0), turtle.getPos());
        turtle.getGrid().clear();
        turtle.moveTo(new Point(0, 0));
        turtle.turnTo(0);
    }

    @Override
    public Command copy() {
        return new ClearScreenCommand();
    }
}
