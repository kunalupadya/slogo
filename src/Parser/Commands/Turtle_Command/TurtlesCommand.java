package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class TurtlesCommand extends TurtleCommand {

    public TurtlesCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        returnValue = backendController.getMyTurtles().size();
    }

    @Override
    protected void turtleAction(Turtle turtle) {

    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}