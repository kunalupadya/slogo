package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

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
    protected void performAction(BackendController backendController) {
        setReturnValue(new Random().nextInt((int)getChildren().get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new RandomCommand();
    }
}
