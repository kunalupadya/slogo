package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */

public class SetShapeCommand extends TurtleCommand {

    public SetShapeCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        turtle.setMyShape((int) getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SetShapeCommand();
    }
}
