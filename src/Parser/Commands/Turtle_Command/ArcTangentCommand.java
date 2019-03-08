package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;


public class ArcTangentCommand extends Command {

    public ArcTangentCommand(){
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.atan(Math.toRadians(myChildrenList.get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new ArcTangentCommand();
    }
}
