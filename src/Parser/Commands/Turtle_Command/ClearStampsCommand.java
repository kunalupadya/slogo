package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;
import Parser.SLogoException;

public class ClearStampsCommand extends TurtleCommand {
    public ClearStampsCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        backendController.clearStamps();
        setReturnValue(1);
    }
}
