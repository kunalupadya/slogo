package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

import java.util.List;

public class IDCommand extends TurtleCommand {

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

    @Override
    public Command copy() {
        return new IDCommand();
    }


}
