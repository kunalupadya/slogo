package Parser.Commands.Turtle_Command;


import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class ForwardCommand extends Command {

    public ForwardCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        if (turtle.getIsTurtleActive()) {
            turtle.move(getChildren().get(0).getReturnValue());
        }
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new ForwardCommand();
    }
}
