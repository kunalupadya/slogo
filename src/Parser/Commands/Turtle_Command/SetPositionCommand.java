package Parser.Commands.Turtle_Command;

import GraphicsBackend.Point;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class SetPositionCommand extends Command{

    public SetPositionCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        Point newPos =  new Point(getChildren().get(0).getReturnValue(), getChildren().get(1).getReturnValue());
        setReturnValue(distance(turtle.getPos(),newPos));
        if (turtle.getIsTurtleActive()) {
            turtle.moveTo(newPos);
        }
    }

    @Override
    public Command copy() {
        return new SetPositionCommand();
    }
}
