package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kunalupadya
 */
public class AskCommand extends Command{

    public static final int LIST_END_COMMAND_OFFSET = 1;
    public static final int TURTLES_INDEX = 0;
    private ArrayList<Turtle> assignedTurtleList = new ArrayList<>();

    public AskCommand(){
        setIsEvaluated(false);
        setNumParameters(2);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController){
        Command turtleList = getChildren().get(TURTLES_INDEX);
//        Command commandsToExecute = getChildren().get(1);

        if(turtleList.getClass() != ListStartCommand.class){
            //TODO "Wrong syntax error"
        }
        List<Turtle>turtles = backendController.getMyTurtles();
        for (Turtle t:turtles){
            t.setTurtleActive(false);
        }



        for(int currentTurtleFromList = 0; currentTurtleFromList<turtleList.getChildren().size() - LIST_END_COMMAND_OFFSET; currentTurtleFromList++){
            turtles.get((int) turtleList.getChildren().get(currentTurtleFromList).getReturnValue()-1).setTurtleActive(true);
        }
    }

    @Override
    public Command copy() {
        return new AskCommand();
    }

}