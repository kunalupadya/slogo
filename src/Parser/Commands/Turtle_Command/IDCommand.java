package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class IDCommand extends Command {

    private int turtleId;
    private ArrayList<Turtle> aliveTurtles;

    public IDCommand(){
        setNumParameters(0);
        isOutputCommand = true;
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

    @Override
    public Command copy() {
        return new IDCommand();
    }


}
