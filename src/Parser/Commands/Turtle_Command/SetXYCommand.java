package Parser.Commands.Turtle_Command;

import Parser.Commands.TurtleCommand;

public class SetXYCommand extends TurtleCommand{

    public SetXYCommand(){
        isConstant = false;
        numParameters = 0;
    }

    public void performAction() {
        returnValue =  Math.sqrt(Math.pow((getTurtle().getxPos()- getChildren().get(0).getReturnValue()), 2) + Math.pow((getTurtle().getyPos() - getChildren().get(1).getReturnValue()),2));
        getTurtle().setxPos((getChildren().get(0).getReturnValue()));
        getTurtle().setyPos(getChildren().get(0).getReturnValue());
    }
}
