package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

import java.util.ArrayList;
import java.util.List;

public class UserDefinedCommand extends Command {
    String name;
    private List<Variable> variables;
    private ListStartCommand headNode;

    UserDefinedCommand(String name, List<Variable> variables, ListStartCommand headNode){
        this.name = name;
        this.variables = variables;
        this.headNode = headNode;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public ListStartCommand getHeadNode() {
        return headNode;
    }

    @Override
    protected void performAction(BackendController backendController) {

    }
}
