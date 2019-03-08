package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

public class CosineCommand extends Command {

    public CosineCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  Math.cos(Math.toRadians(myChildrenList.get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new CosineCommand();
    }
}
