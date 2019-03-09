package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class HomeCommand extends TurtleCommand {

    public HomeCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        setReturnValue(Math.sqrt(Math.pow(turtle.getxPos(), 2) + Math.pow(turtle.getyPos(),2)));
        turtle.moveTo(new Point(0,0));
        turtle.turnTo(0);
    }

    @Override
    public Command copy() {
        return new HomeCommand();
    }
}
