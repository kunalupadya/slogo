package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class PenColorCommand extends TurtleCommand {

    private Color myColor;
    private int myColorIndex;

    public PenColorCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        myColor = backendController.getColor((int)getChildren().get(0).getReturnValue());
        myColorIndex = backendController.getColorPaletteIndex(myColor);
        System.out.println(myColor);
        System.out.println(myColorIndex);
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

