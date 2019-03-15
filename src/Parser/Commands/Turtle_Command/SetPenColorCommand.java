package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetPenColorCommand extends TurtleCommand {

    public SetPenColorCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(getChildren().get(0).getReturnValue());
        //TODO: handle nullpointer for if index doesn't exist in Palette
        turtle.setPenColor(backendController.getColor((int) getReturnValue()));
    }

    @Override
    public Command copy() {
        return new SetPenColorCommand();
    }
}
