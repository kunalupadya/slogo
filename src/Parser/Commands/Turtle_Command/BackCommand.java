package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class BackCommand extends TurtleCommand {

    public BackCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        getTurtle().move(-getChildren().get(0).getReturnValue());
        returnValue = getChildren().get(0).getReturnValue();
    }

}
