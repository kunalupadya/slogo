package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;

public class ProductCommand extends Command {

    public ProductCommand(){
        isConstant = false;
        numParameters = 2;
    }

    public void performAction(){
        returnValue = myChildrenList.get(0).getReturnValue() * myChildrenList.get(1).getReturnValue();
    }


}
