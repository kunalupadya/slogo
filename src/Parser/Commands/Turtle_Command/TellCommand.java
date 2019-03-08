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
        isEvaluated = false;
        numParameters = 1;
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
        returnValue = assignedTurtleList.size();
    }


    @Override
    public Command copy() {
        return new TellCommand();
    }


}
