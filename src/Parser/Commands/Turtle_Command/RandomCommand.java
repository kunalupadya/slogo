package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

import java.util.Random;

public class RandomCommand extends Command {

    public RandomCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
        isOutputCommand = true;
    }

    public void performAction(BackendController backendController){
        setNumParameters(new Random().nextInt((int)getChildren().get(0).getReturnValue()));
    }

    @Override
    public Command copy() {
        return new RandomCommand();
    }
}
