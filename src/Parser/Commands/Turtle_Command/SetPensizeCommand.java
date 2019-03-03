package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class SetPensizeCommand extends TurtleCommand {


    public SetPensizeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        getTurtle().getMyPen().setPenSize((int)getChildren().get(0).getReturnValue());
    }
}
