package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command returns turtle's current color index.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class GetPenColorCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public GetPenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getColorPaletteIndex(turtle.getMyPen().getMyPenColor()) + 1);
    }

}

