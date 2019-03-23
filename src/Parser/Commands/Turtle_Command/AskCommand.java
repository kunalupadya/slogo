package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * For this command, only the turtles given in first list all run commands given in the second list.
 *
 * @author Dhanush Madabusi
 */
public class AskCommand extends BasicCommand {

    private static final int TURTLES_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;

    /**
     * Command Constructor
     */
    public AskCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        int numTurtles = backendController.getMyTurtles().size();
        for (Command com: getChildren().get(TURTLES_INDEX).getChildren()){
            if (com instanceof ListEndCommand){
                break;
            }
            else if (com.getReturnValue() > numTurtles){
                throw new ExecutionException("Turtle does not exist");
            }
            else if (com.getReturnValue() < 1){
                throw new ExecutionException("Invalid Turtle Id");
            }
        }
        if (getChildren().get(COMMANDS_INDEX).getClass() != ListStartCommand.class){
            throw new ExecutionException("AskWith Command is missing a List of Commands");
        }
    }

}