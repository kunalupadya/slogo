package Parser.Commands.Turtle_Command;

import GraphicsBackend.Grid;
import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.ExecutionException;
import Parser.SLogoException;
import java.util.List;

/**
 * Command sets turtles that will follow commands hereafter.
 *
 * @author kunalupadya
 * @author Dhanush Madabusi
 */
public class TellCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public TellCommand(){
        setNumParameters(1);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        Command listCommand = getChildren().get(0);
        var childrenSize = listCommand.getChildren().size();
        for (Turtle t: backendController.getMyTurtles()){
            t.setTurtleActive(false);
        }
        for (int a = 0; a < childrenSize - 1; a++) {
            List<Turtle> turtleList= backendController.getMyTurtles();
            int turtleId = (int) listCommand.getChildren().get(a).getReturnValue();
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

    private void handleExceptions() throws ExecutionException{
        Command listCommand = getChildren().get(0);
        if (!(listCommand instanceof ListStartCommand)) {
            throw new ExecutionException("Tell Command is missing List parameter");
        }
        for (Command com: listCommand.getChildren()){
            if (com.getClass() == ListEndCommand.class){
                break;
            }
            if ((int) com.getReturnValue() < 1){
                throw new ExecutionException("Turtle Ids less than 1 are invalid");
            }
        }
    }

}
