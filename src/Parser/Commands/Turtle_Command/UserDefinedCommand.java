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

    public UserDefinedCommand(String name, List<Variable> variables, ListStartCommand headNode){
        this.name = name;
        this.variables = variables;
        this.headNode = headNode;
        isConstant = false;
        numParameters = variables.size();
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

    }

    @Override
    public Command copy() {
        //        List<Variable> newVariables;
//        ListStartCommand newHeadNode;
//
//        traverse()
//
//        new UserDefinedCommand()

        ListStartCommand newHeadNode = (ListStartCommand) traverse(headNode);
        return new UserDefinedCommand(name, variables, newHeadNode);
    }
}
