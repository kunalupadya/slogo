package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class ClearScreenCommand extends TurtleCommand {

    public ClearScreenCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = false;
    }

    protected void turtleAction(Turtle turtle) {
        setReturnValue(distance(new Point(0,0), turtle.getPos()));
        turtle.getGrid().clear();
        turtle.moveTo(new Point(0, 0));
        turtle.turnTo(0);
    }

    @Override
    public Command copy() {
        return new ClearScreenCommand();
    }
}
