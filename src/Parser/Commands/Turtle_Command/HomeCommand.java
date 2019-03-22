package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class HomeCommand extends TurtleCommand {

    public HomeCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(Math.sqrt(Math.pow(turtle.getxPos(), 2) + Math.pow(turtle.getyPos(),2)));
        turtle.moveTo(new Point(0, 0));
        turtle.turnTo(0);
    }

    @Override
    public Command copy() {
        return new HomeCommand();
    }
}
