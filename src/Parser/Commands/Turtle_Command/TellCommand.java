package Parser.Commands.Turtle_Command;

import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kunalupadya
 */
public class TellCommand extends Command{

    private List<Turtle> assignedTurtleList = new ArrayList<>();
    public TellCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Command startCommand = getChildren().get(0);
        if (!startCommand.toString().equals("ListStartCommand")) {
            //TODO "Wrong syntax error"
        }

        List<Turtle> turtleList= backendController.getMyTurtles();
        for (int a = 0; a < startCommand.getChildren().size() - 1; a++) {
            int turtleIndex = (int) startCommand.getChildren().get(a).getReturnValue();
            if (turtleIndex < turtleList.size()) {
                assignedTurtleList.add(turtleList.get(turtleIndex));
            }
            else {
                while(turtleIndex>turtleList.size()) {
                    Turtle newTurtle = new Turtle((Grid) backendController.getMyGrid());
                    turtleList.add(newTurtle);
                    assignedTurtleList.add(newTurtle);
                }
            }

        }
        for (Turtle turtle : assignedTurtleList) {
            turtle.setTurtleActive(true);
        }
        setReturnValue(startCommand.getChildren().get(startCommand.getChildren().size()-2).getReturnValue());
    }


    @Override
    public Command copy() {
        return new TellCommand();
    }


}
