package Parser.Commands.Turtle_Command;

import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.ExecutionException;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class defines specific set of methods and instance variables for Control Commands, such as For, DoTimes,
 * Repeat, If, and IfElse.
 *
 * @author Dhanush Madabusi
 */
public abstract class ControlCommand extends BasicCommand {

    boolean runAgain = true;
    int currCount = 1;
    int limit;
    List<Command> initialExpressions = new ArrayList<>();
    private ListStartCommand listToRun = null;

    ControlCommand(){
        isOutputCommand = false;
        setReturnValue(0);
        setIsEvaluated(false);
    }

    /**
     * Returns list of commands to evaluate prior to evaluating main command.
     *
     * @return list of commands to evaluate prior to evaluating main command
     */
    public List<Command> getInitialExpressions(){
        return initialExpressions;
    }

    /**
     * Abstract methods to be implemented by sub classes. Determines which expressions to evaluate prior to evaluating
     * main command.
     */
    public abstract void setInitialExpressions();

    /**
     * Returns runAgain variable, which determines if command is done running or should be evaluated again.
     *
     * @return runAgain instance variable
     */
    public boolean shouldRunAgain(){
        return runAgain;
    }

    void setListToRun(ListStartCommand list){
        listToRun = list;
    }

    /**
     * Returns the list of commands to evaluate.
     *
     * @return ListStartCommand listToRun for ExecuteCommand to run
     */
    public ListStartCommand getListToRun(){
        return listToRun;
    }

    ListStartCommand copyList(ListStartCommand command){
        return (ListStartCommand) traverse(command);
    }

    /**
     * Abstract methods to be evaluated by sub classes. Sets up any instance variable prior to evaluating any loop commands.
     *
     * @throws ExecutionException if an error occurs while executing
     */
    public abstract void setUpLoop() throws ExecutionException;

    private Command traverse(Command command){
        Command newHeadNode;
        newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(traverse(c));
        }
        return newHeadNode;
    }

}
