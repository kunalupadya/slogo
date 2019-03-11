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

    private List<Turtle> activeTurtles = new ArrayList<>();

    public TellCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        Command listCommand = getChildren().get(0);
        if (!(listCommand instanceof ListStartCommand)) {
            //TODO "Wrong syntax error"
        }
        for (int a = 0; a < listCommand.getChildren().size() - 1; a++) {
            List<Turtle> turtleList= backendController.getMyTurtles();
            int turtleIndex = (int) listCommand.getChildren().get(a).getReturnValue();
            //TODO catch error for TELL to turtle 0
            if (turtleIndex <= turtleList.size()) {
                activeTurtles.add(turtleList.get(turtleIndex));
            }
            else {
                while(turtleIndex > turtleList.size()) {
                    Turtle newTurtle = new Turtle((Grid) backendController.getMyGrid());
                    turtleList.add(newTurtle);
                    activeTurtles.add(newTurtle);
                }
            }
        }
        turtle.setTurtleActive(activeTurtles.contains(turtle));
        setReturnValue(listCommand.getChildren().get(listCommand.getChildren().size() - 2).getReturnValue());
    }

    @Override
    public Command copy() {
        return new TellCommand();
    }


}
