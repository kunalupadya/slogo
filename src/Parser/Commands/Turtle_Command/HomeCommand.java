package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command moves turtle to the center of the screen (0, 0).
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class HomeCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public HomeCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(Math.sqrt(Math.pow(turtle.getUserFriendlyXPos(), 2) + Math.pow(turtle.getUserFriendlyYPos(),2)));
        turtle.moveTo(new Point(0, 0));
        turtle.turnTo(0);
    }
}
