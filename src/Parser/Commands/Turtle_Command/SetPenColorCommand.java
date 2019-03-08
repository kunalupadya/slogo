package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class SetPenColorCommand extends TurtleCommand {

    private Color myColor;

    public SetPenColorCommand(){
        setIsEvaluated(false);
        setNumParameters(1);
    }

    @Override
    protected void performAction(BackendController backendController){
        myColor = backendController.getColor((int)getChildren().get(0).getReturnValue());
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        turtle.setPenColor(myColor);
        setReturnValue(getChildren().get(0).getReturnValue());
    }

    @Override
    public Command copy() {
        return new SetPenColorCommand();
    }
}
