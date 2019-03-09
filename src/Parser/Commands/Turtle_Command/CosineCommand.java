package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class CosineCommand extends Command {

    public CosineCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.cos(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new CosineCommand();
    }
}
