package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class GetPenColorCommand extends Command {

    private Color myColor;

    public GetPenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }


    @Override
    protected void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
                setReturnValue(backendController.getColorPaletteIndex(myColor));
            }
        }
    }
    
    protected void turtleAction(Turtle turtle) {
        myColor = turtle.getMyPen().getMyPenColor();
    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

