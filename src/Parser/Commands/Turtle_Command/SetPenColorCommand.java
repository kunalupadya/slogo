package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class SetPenColorCommand extends TurtleCommand {

    private Color myColor;

    public SetPenColorCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void performAction(BackendController backendController){
        myColor = backendController.getColor((int)getChildren().get(0).getReturnValue());
        System.out.println(myColor);
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.getMyPen().setPenColor(myColor);
        returnValue = getChildren().get(0).getReturnValue();
        System.out.println(myColor);
        System.out.println(returnValue);
    }

    @Override
    public Command copy() {
        return new SetPenColorCommand();
    }
}
