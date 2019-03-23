package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.Commands.Variable;
import java.util.LinkedList;
import java.util.List;

/**
 * This command class handles user-defined commands and its list of variables and commands.
 *
 * @author kunalupadya
 */
public class UserDefinedCommand extends BasicCommand implements ImmutableUserDefinedCommand{
    private String name;
    private List<Variable> variables;
    private ListStartCommand headNode;

    /**
     * Command Constructor
     */
    public UserDefinedCommand(String name, List<Variable> variables, ListStartCommand headNode){
        isOutputCommand = false;
        this.name = name;
        this.variables = variables;
        this.headNode = headNode;
        getChildren().add(headNode);
        setNumParameters(variables.size());
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public ListStartCommand getHeadNode() {
        return headNode;
    }

    private Command traverse(Command command){
        Command newHeadNode;
        newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(traverse(c));
        }
        return newHeadNode;
    }

    @Override
    protected void performAction(BackendController backendController) {
        backendController.removeUserDefinedCommandFromStack(this);
    }

    /**
     * Returns copy of command
     *
     * @return copy of command
     */
    @Override
    public Command copy() {
        List<Variable> newVariables = new LinkedList<>();
        for (Variable v: variables){
            newVariables.add((Variable) v.copy());
        }
        ListStartCommand newHeadNode = (ListStartCommand) traverse(headNode);
        return new UserDefinedCommand(name, newVariables, newHeadNode);
    }
}
