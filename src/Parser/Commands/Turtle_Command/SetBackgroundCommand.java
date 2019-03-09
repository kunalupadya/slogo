package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SetBackgroundCommand extends Command {

    public SetBackgroundCommand(){
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        //TODO: handle nullpointer for if index doesn't exist in Palette
        backendController.setBackGroundColor(backendController.getColor((int)getChildren().get(0).getReturnValue()));

    }
    @Override
    public Command copy() {
        return new SetBackgroundCommand();
    }
}
