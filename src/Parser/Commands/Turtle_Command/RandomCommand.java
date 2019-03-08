package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

import java.util.Random;

public class RandomCommand extends Command {

    public RandomCommand(){
        isEvaluated = false;
        numParameters = 1;
    }

    public void performAction(BackendController backendController){
        returnValue =  new Random().nextInt((int)myChildrenList.get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new RandomCommand();
    }
}
