package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class GetPenColorCommand extends TurtleCommand {

    private Color myColor;

    public GetPenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        setReturnValue(backendController.getColorPaletteIndex(turtle.getMyPen().getMyPenColor()));
    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

