package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetPenSizeCommand extends TurtleCommand {

    public SetPenSizeCommand(){
<<<<<<< HEAD
        setIsEvaluated(false);
        setNumParameters(1);
=======
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 1;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setPenSize((int)getChildren().get(0).getReturnValue());
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SetPenSizeCommand();
    }
}
