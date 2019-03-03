package Parser.Commands.Display_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.TurtleCommand;

public class SetShapeCommand extends TurtleCommand {

    public SetShapeCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void turtleAction(Turtle turtle){
       turtle.setMyShape((int)getChildren().get(0).getReturnValue());
    }
}
