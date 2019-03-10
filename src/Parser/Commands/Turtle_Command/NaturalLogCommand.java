package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class NaturalLogCommand extends Command {

    public NaturalLogCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(Math.log(getChildren().get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new NaturalLogCommand();
    }
}
