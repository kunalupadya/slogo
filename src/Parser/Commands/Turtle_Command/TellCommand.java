package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import java.util.ArrayList;
import java.util.List;

public class TellCommand extends Command{

    private ArrayList<Turtle> assignedTurtleList = new ArrayList<>();
    public TellCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Command startCommand = getChildren().get(0);
        if (!startCommand.toString().equals("ListStartCommand")) {
            //TODO "Wrong syntax error"
        }

        List<Turtle> turtleList= backendController.getMyTurtles();
        for (int a = 0; a < startCommand.getChildren().size() - 1; a++) {
            System.out.println(startCommand.getChildren().size() -1);
            if (a < turtleList.size()) {
                assignedTurtleList.add(turtleList.get((int) startCommand.getChildren().get(0).getReturnValue()));
            } else {
                Turtle newOne = new Turtle(backendController.getMyGrid());
                turtleList.add(newOne);
                assignedTurtleList.add(newOne);
            }

        }
        System.out.println(assignedTurtleList.size());
        for (Turtle turtle : assignedTurtleList) {
            turtle.setTurtleActive(true);
        }
        returnValue = assignedTurtleList.size();
    }

    @Override
    public Command copy() {
        return new TellCommand();
    }


}
