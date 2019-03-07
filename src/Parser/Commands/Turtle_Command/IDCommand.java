package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

import java.util.ArrayList;

public class IDCommand extends TurtleCommand {

    private int turtleId;
    private ArrayList<Turtle> aliveTurtles;
    public IDCommand(){
        isConstant = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                aliveTurtles.add(turtle);
                turtleAction(turtle);
            }
        }
        turtleId = aliveTurtles.size() -1;

        for (Turtle turtle: backendController.getMyTurtles()) {
            if (turtle.getIsTurtleActive()) {
                turtleAction(turtle);
            }
        }
    }

    @Override
    protected void turtleAction(Turtle turtle) {
        returnValue = turtleId;
    }

    @Override
    public Command copy() {
        return new IDCommand();
    }


}
