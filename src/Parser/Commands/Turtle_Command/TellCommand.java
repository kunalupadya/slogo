package Parser.Commands.Turtle_Command;

import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import java.util.List;

/**
 * @author kunalupadya
 */
public class TellCommand extends BasicCommand {

    public TellCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Command listCommand = getChildren().get(0);
        if (!(listCommand instanceof ListStartCommand)) {
            //TODO "Wrong syntax error"
        }
        var childrenSize = listCommand.getChildren().size();
        for (int a = 0; a < childrenSize - 1; a++) {
            List<Turtle> turtleList= backendController.getMyTurtles();
            int turtleId = (int) listCommand.getChildren().get(a).getReturnValue();
            //TODO catch error for TELL to turtle 0
            if (turtleId <= turtleList.size()) {
                turtleList.get(turtleId - 1).setTurtleActive(true);
            }
            else {
                while(turtleId > turtleList.size()) {
                    Turtle newTurtle = new Turtle((Grid) backendController.getMyGrid());
                    turtleList.add(newTurtle);
                }
            }
        }
        setReturnValue(listCommand.getChildren().get(childrenSize - 2).getReturnValue());
    }

    @Override
    public Command copy() {
        return new TellCommand();
    }


}
