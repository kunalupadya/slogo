package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class SetShapeCommand extends TurtleCommand {

    public SetShapeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    public void performAction(){
       getTurtle().setMyShape((int)getChildren().get(0).getReturnValue());
    }
}
