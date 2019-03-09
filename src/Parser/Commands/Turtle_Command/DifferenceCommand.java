package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class DifferenceCommand extends Command {

    public DifferenceCommand(){
        setNumParameters(2);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController){
        setReturnValue(myChildrenList.get(0).getReturnValue() - myChildrenList.get(1).getReturnValue());
    }

    @Override
    public Command copy() {
        return new DifferenceCommand();
    }
}
