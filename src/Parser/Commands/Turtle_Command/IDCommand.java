package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.TurtleCommand;

import java.util.ArrayList;
import java.util.List;

public class IDCommand extends TurtleCommand {

    private int turtleId;
    private List<Turtle> aliveTurtles = new ArrayList<>();

    public IDCommand(){
        isOutputCommand = true;
        isEvaluated = false;
        numParameters = 0;
    }

    @Override
    protected void performAction(BackendController backendController){
        List<Turtle> turtleList = backendController.getMyTurtles();
        for (int i = 0; i < turtleList.size(); i++) {
            if (turtleList.get(i).getIsTurtleActive()) {
                returnValue = i + 1;
                break;
            }
        }

//        for (Turtle turtle: backendController.getMyTurtles()) {
//            if (turtle.getIsTurtleActive()) {
//                aliveTurtles.add(turtle);
//                turtleAction(turtle);
//            }
//        }
//        returnValue = aliveTurtles.size();
//
//        for (Turtle turtle: backendController.getMyTurtles()) {
//            if (turtle.getIsTurtleActive()) {
//                turtleAction(turtle);
//            }
//        }
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