package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;


public class ArcTangentCommand extends Command {

    public ArcTangentCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
    }

    public void performAction(BackendController backendController){
        setReturnValue(Math.atan(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new ArcTangentCommand();
    }
}
