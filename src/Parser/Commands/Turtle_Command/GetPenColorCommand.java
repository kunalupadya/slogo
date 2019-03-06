package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

public class GetPenColorCommand extends TurtleCommand {

    private Color myColor;

    public GetPenColorCommand(){
        isConstant = false;
        numParameters = 0;
    }


    @Override
    protected void performAction(BackendController backendController){
        returnValue = backendController.getColorPaletteIndex(myColor);
        System.out.println(myColor);
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        myColor = turtle.getMyPen().getMyPenColor();
        System.out.println(myColor);

    }

    @Override
    public Command copy() {
        return new GetPenColorCommand();
    }


}

