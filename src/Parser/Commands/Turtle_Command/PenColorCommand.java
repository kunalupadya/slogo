package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;
import javafx.scene.paint.Color;

import java.util.List;

public class PenColorCommand extends Command {

    public PenColorCommand(){
        setNumParameters(0);
        isOutputCommand = true;
    }

    @Override
    protected void performAction(BackendController backendController){
        int lastActiveTurtleIndex = 0;
        List<Turtle> turtleList = backendController.getMyTurtles();
        for (int i = 0; i < turtleList.size(); i++){
            if (turtleList.get(i).getIsTurtleActive()){
                lastActiveTurtleIndex = i;
            }
        }
        Turtle lastActive = turtleList.get(lastActiveTurtleIndex);
        setReturnValue(backendController.getColorPaletteIndex(lastActive.getMyPen().getMyPenColor()));
    }


    @Override
    public Command copy() {
        return new PenColorCommand();
    }

}

