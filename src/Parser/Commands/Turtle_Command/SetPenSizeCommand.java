package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class SetPenSizeCommand extends TurtleCommand {

    private int myPenSize;

    public SetPenSizeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        myPenSize = (int)getChildren().get(0).getReturnValue();
        System.out.println(myPenSize);
        turtle.getMyPen().setPenSize(myPenSize);
        returnValue = myPenSize;
        System.out.println(myPenSize);
    }

    @Override
    public Command copy() {
        return new SetPenSizeCommand();
    }
}
