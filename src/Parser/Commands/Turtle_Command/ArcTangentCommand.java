package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;


public class ArcTangentCommand extends Command {

    public ArcTangentCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController, Turtle turtle){
        setReturnValue(Math.atan(Math.toRadians(getChildren().get(0).getReturnValue())));
    }

    @Override
    public Command copy() {
        return new ArcTangentCommand();
    }
}
