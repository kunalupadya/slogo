package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class NaturalLogCommand extends Command {

    public NaturalLogCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.log(getChildren().get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new NaturalLogCommand();
    }
}
