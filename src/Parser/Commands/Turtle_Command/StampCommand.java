package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.TurtleCommand;
import Parser.SLogoException;

public class StampCommand extends TurtleCommand {
    public StampCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        backendController.addToMyStamps(new Turtle(turtle));
        setReturnValue(turtle.getMyShape());
    }
}