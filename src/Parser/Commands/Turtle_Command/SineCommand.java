package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SineCommand extends Command {

    public SineCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.sin(Math.toRadians(myChildrenList.get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new SineCommand();
    }
}
