package Parser.Commands.Turtle_Command;


import Parser.Commands.BasicCommand;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class ControlCommand extends BasicCommand {

    boolean runAgain = true;
    int currCount = 1;
    int limit;
    List<Command> initialExpressions = new ArrayList<>();
    private ListStartCommand listToRun = null;

    ControlCommand(){
        isOutputCommand = false;
        setReturnValue(0);
    }

    public List<Command> getInitialExpressions(){
        return initialExpressions;
    }

    public abstract void setInitialExpressions();

    public boolean shouldRunAgain(){
        return runAgain;
    }

    void setListToRun(ListStartCommand list){
        listToRun = list;
    }

    public ListStartCommand getListToRun(){
        return listToRun;
    }

    ListStartCommand copyList(ListStartCommand command){
        return (ListStartCommand) traverse(command);
    }

    public abstract void setUpLoop();

    private Command traverse(Command command){

        Command newHeadNode;
        newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(traverse(c));
        }
        return newHeadNode;
    }

}
