package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class PenColorCommand extends TurtleCommand {

    private Color myColor;
    private int myColorIndex;

    public PenColorCommand(){
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        myColor = backendController.getColor((int)getChildren().get(0).getReturnValue());
        myColorIndex = backendController.getColorPaletteIndex(myColor);
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = myColorIndex;
    }

    @Override
    public Command copy() {
        return new PenColorCommand();
    }

}

