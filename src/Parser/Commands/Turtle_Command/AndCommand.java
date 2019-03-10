package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

public class AndCommand extends BooleanCommand{

    public AndCommand(){
        super();
        setNumParameters(2);
    }

    public void performAction(BackendController backendController, Turtle turtle){
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() != 0 &&
                getChildren().get(1).getReturnValue() != 0));
    }

    @Override
    public Command copy() {
        return new AndCommand();
    }
}
