package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.ExecutionException;
import java.util.Random;

/**
 * Command returns random non-negative number strictly less than max param.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class RandomCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public RandomCommand(){
        setNumParameters(1);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController) throws ExecutionException{
        if (getChildren().get(0).getReturnValue() < 0){
            String currCommandClass = this.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " does not accept negative numbers");
        }
        setReturnValue(new Random().nextInt((int)getChildren().get(0).getReturnValue()));
    }

}
