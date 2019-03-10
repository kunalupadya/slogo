package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class SetBackgroundCommand extends Command {

    public SetBackgroundCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(getChildren().get(0).getReturnValue());
        //TODO: handle nullpointer for if index doesn't exist in Palette
        if (turtle.getIsTurtleActive()) {
            backendController.setBackGroundColor(backendController.getColor((int) getReturnValue()));
        }
    }

    @Override
    public Command copy() {
        return new SetBackgroundCommand();
    }
}
