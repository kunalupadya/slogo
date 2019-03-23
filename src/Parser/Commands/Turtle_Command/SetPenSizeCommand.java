package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command sets size of the turtle pen to be pixels param thickness.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SetPenSizeCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public SetPenSizeCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setPenSize((int) getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

}
