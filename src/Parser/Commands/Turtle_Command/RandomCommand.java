package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.ExecutionException;

import java.util.Random;

/**
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush
 */


public class RandomCommand extends BasicCommand {

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

    @Override
    public Command copy() {
        return new RandomCommand();
    }
}
