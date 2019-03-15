package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

/**
 * @author Dhanush Madabusi
 */
public class AskCommand extends BasicCommand {

    private static final int TURTLES_INDEX = 0;

    public AskCommand(){
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        int numTurtles = backendController.getMyTurtles().size();
        for (Command com: getChildren().get(TURTLES_INDEX).getChildren()){
            if (com instanceof ListEndCommand){
                break;
            }
            else if (com.getReturnValue() > numTurtles){
                //TODO turtle does not exist
            }
            else if (com.getReturnValue() < 1){
                //TODO invalid input
            }
        }
        if (getChildren().get(1).getClass() != ListStartCommand.class){
            //TODO throw error
        }
    }

    @Override
    public Command copy() {
        return new AskCommand();
    }

}