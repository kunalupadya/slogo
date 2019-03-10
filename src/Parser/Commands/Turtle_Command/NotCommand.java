package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        super();
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() == 0));
    }

    @Override
    public Command copy() {
        return new NotCommand();
    }
}
