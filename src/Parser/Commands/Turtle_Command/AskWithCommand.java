package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author Dhanush Madabusi
 */
public class AskWithCommand extends BasicCommand {

    private final int CONDITION_INDEX = 0;
    private final int COMMANDS_INDEX = 1;

    public AskWithCommand(){
        isOutputCommand = false;
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) {
        if (getChildren().get(COMMANDS_INDEX).getClass() != ListStartCommand.class){
            //TODO throw error
        }
        if (getChildren().get(CONDITION_INDEX).getChildren().size() > 2){
            //TODO throw error; can only have one condition
        }

    }

    @Override
    public Command copy() {
        return new AskWithCommand();
    }
}
