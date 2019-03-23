package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command erases turtle's trails and sends it to the home position.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class ClearScreenCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public ClearScreenCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(distance(new Point(0,0), turtle.getPos()));
        turtle.getGrid().clear();
        turtle.moveTo(new Point(0, 0));
        turtle.turnTo(0);
    }
}
