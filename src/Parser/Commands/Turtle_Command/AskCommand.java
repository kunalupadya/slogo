package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kunalupadya
 */
public class AskCommand extends Command{

    private static final int LIST_END_COMMAND_OFFSET = 1;
    private static final int TURTLES_INDEX = 0;
    private List<Turtle> assignedTurtleList = new ArrayList<>();
    private Set<Turtle> turtlesToAsk = new HashSet<>();

    public AskCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        if(getChildren().get(TURTLES_INDEX).getClass() != ListStartCommand.class){
            //TODO "Wrong syntax error"
        }
        List<Turtle> turtleList = backendController.getMyTurtles();
        int numTurtles = backendController.getMyTurtles().size();
        for (Command com: getChildren().get(TURTLES_INDEX).getChildren()){
            if (com instanceof ListEndCommand){
                break;
            }
            if (com.getReturnValue() > numTurtles){
                //TODO turtle does not exist
            }
            if (com.getReturnValue() < 1){
                //TODO invalid input
            }
            else{
                turtlesToAsk.add(turtleList.get((int) com.getReturnValue() - 1));
            }
        }
        turtle.setTurtleActive(turtlesToAsk.contains(turtle));
    }

    @Override
    public Command copy() {
        return new AskCommand();
    }

}