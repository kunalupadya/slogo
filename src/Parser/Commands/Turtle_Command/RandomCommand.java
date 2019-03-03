package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

import java.util.Random;

public class RandomCommand extends Command {

    public RandomCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        returnValue =  new Random().nextInt((int)myChildrenList.get(0).getReturnValue());
    }


}
