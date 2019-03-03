package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class SetPenColorCommand extends TurtleCommand {

    public SetPenColorCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
        //getTurtle().getMyPen().setPenColor(getChildren().get(0).getReturnValue());
    }
}
