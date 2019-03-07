package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;

import java.util.ArrayList;

public class AskCommand extends Command{

    private ArrayList<Turtle> assignedTurtleList = new ArrayList<>();
    public AskCommand(){
        isConstant = false;
        numParameters = 1;
    }

    @Override
    protected void performAction(BackendController backendController){
        Command startOfTurtle = getChildren().get(0);
        Command startOfCommand = getChildren().get(1);

        if(!startOfTurtle.toString().equals("ListStartCommand")){
            //TODO "Wrong syntax error"
        }
        for(int a=0; a<startOfTurtle.getChildren().size() -1; a++){
            assignedTurtleList.add(backendController.getMyTurtles().get((int)startOfTurtle.getChildren().get(0).getReturnValue()));
        }
        for (Turtle turtle: assignedTurtleList) {
            

        }
    }

    @Override
    public Command copy() {
        return new AskCommand();
    }

}
