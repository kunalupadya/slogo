package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

public class SetBackgroundCommand extends BasicCommand {

    public SetBackgroundCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        //TODO no values below 1; 1 based indexing
        setReturnValue(getChildren().get(0).getReturnValue());
        //TODO: handle nullpointer for if index doesn't exist in Palette
        backendController.setBackGroundColor(backendController.getColor((int) getReturnValue() - 1));
    }

    @Override
    public Command copy() {
        return new SetBackgroundCommand();
    }
}
