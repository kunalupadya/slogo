package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * This command tells turtles matching given condition to run commands given in the second list.
 *
 * @author Dhanush Madabusi
 */
public class AskWithCommand extends BasicCommand {

    private static final int CONDITION_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;

    /**
     * Command Constructor
     */
    public AskWithCommand(){
        isOutputCommand = false;
        setNumParameters(2);
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        if (getChildren().get(COMMANDS_INDEX).getClass() != ListStartCommand.class){
            throw new ExecutionException("AskWith Command is missing a List of Commands");
        }
        if (getChildren().get(CONDITION_INDEX).getChildren().size() > 2){
            throw new ExecutionException("AskWith Command can only have one condition");
        }

    }

}
