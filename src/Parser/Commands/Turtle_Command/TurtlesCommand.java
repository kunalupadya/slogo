package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

public class TurtlesCommand extends TurtleCommand {

    private int turtleListSize;

    public TurtlesCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        turtleListSize = backendController.getMyTurtles().size();
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = turtleListSize;
    }

    @Override
    public Command copy() {
        return new TurtlesCommand();
    }
}