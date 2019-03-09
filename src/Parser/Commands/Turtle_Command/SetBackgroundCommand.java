package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

public class SetBackgroundCommand extends Command {

    public SetBackgroundCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
        isOutputCommand = false;
    }

    public void performAction(BackendController backendController){
        setReturnValue(getChildren().get(0).getReturnValue());
        //TODO: handle nullpointer for if index doesn't exist in Palette
        backendController.setBackGroundColor(backendController.getColor((int) getReturnValue()));

    }
    @Override
    public Command copy() {
        return new SetBackgroundCommand();
    }
}
