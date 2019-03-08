package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class GetPenColorCommand extends TurtleCommand {

    private Color myColor;

    public GetPenColorCommand(){
        isEvaluated = false;
        numParameters = 0;
    }


    @Override
    protected void performAction(BackendController backendController){
        returnValue = backendController.getColorPaletteIndex(myColor);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        myColor = turtle.getMyPen().getMyPenColor();
    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

