package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeUserInstructionCommand extends Command {

    public static final int NAME_NODE = 0;
    public static final int VARIABLES_LIST_NODE = 1;
    public static final int COMMANDS_LIST_NODE = 2;
    private List< Variable> variables = new ArrayList<>();

    public MakeUserInstructionCommand(){
        isConstant = false;
        numParameters = 3;
    }

    @Override
    protected void performAction(BackendController backendController) {
        returnValue = 0;
        String name = myChildrenList.get(NAME_NODE).getText();
        for (Command variable: myChildrenList.get(VARIABLES_LIST_NODE).getChildren()) {
            if (variable.getClass() == Variable.class) {
                variables.add((Variable) variable);
            }
            else if (variable.getClass() == ListEndCommand.class){

            }
            else{
                // TODO throw new exception, not a variable parameter
            }
        }
        
        if (myChildrenList.get(VARIABLES_LIST_NODE).getClass() != ListStartCommand.class | myChildrenList.get(COMMANDS_LIST_NODE).getClass() != ListStartCommand.class){
            //throw new exception
            //TODO throw exception if either of the two arent lists
        }
        
        UserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, variables, (ListStartCommand) myChildrenList.get(COMMANDS_LIST_NODE));
        
        backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);
        returnValue = 1;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    public Command copy() {
        return new MakeUserInstructionCommand();
    }
}