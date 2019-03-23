package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

/**
 * Command sets shape of turtle to that represented by index param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class SetShapeCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public SetShapeCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setMyShape((int) getChildren().get(0).getReturnValue());
    }

}
