package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.TurtleCommand;

import java.util.List;

/**
 * Command returns current active turtle's ID number.
 *
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class IDCommand extends TurtleCommand {

    /**
     * Command Constructor
     */
    public IDCommand(){
        setNumParameters(0);
        isOutputCommand = true;
        turtleQuery = true;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        List<Turtle> turtleList = backendController.getMyTurtles();
        for (int i = 0; i < turtleList.size(); i++){
            if (turtle.equals(turtleList.get(i))){
                setReturnValue(i + 1);
                break;
            }
        }
    }

}
