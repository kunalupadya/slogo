package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command makes turtle visible.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class ShowTurtleCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public ShowTurtleCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setTurtleVisibility(true);
        setReturnValue(1);
    }

}