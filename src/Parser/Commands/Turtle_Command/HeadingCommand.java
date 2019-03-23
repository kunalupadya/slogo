package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command returns the turtle's heading in degrees.
 *
 * @author kunalupadya
 */
public class HeadingCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public HeadingCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(turtle.getMyAngle() % 360);
    }

}
