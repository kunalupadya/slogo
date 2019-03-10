package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class ClearScreenCommand extends Command {

    public ClearScreenCommand(){
        setIsEvaluated(false);
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(distance(new Point(0,0), turtle.getPos()));
        if (turtle.getIsTurtleActive()) {
            turtle.getGrid().clear();
            turtle.moveTo(new Point(0, 0));
            turtle.turnTo(0);
        }
    }

    @Override
    public Command copy() {
        return new ClearScreenCommand();
    }
}
