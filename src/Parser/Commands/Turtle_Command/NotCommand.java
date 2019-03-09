package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class NotCommand extends BooleanCommand{

    public NotCommand(){
        super();
        setNumParameters(2);
    }

    public void performAction(BackendController backendController){
        setReturnValue(returnValue(getChildren().get(0).getReturnValue() == 0));
    }

    @Override
    public Command copy() {
        return new NotCommand();
    }
}
