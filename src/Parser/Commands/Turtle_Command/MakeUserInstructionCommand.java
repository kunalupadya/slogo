package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kunalupadya
 */
public class MakeUserInstructionCommand extends Command {

    private static final int NAME_NODE = 0;
    private static final int VARIABLES_LIST_NODE = 1;
    private static final int COMMANDS_LIST_NODE = 2;
    private List< Variable> variables = new ArrayList<>();

    public MakeUserInstructionCommand(){
        setNumParameters(3);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(0);
        String name = getChildren().get(NAME_NODE).getText();
        for (Command variable: getChildren().get(VARIABLES_LIST_NODE).getChildren()) {
            if (variable.getClass() == Variable.class) {
                variables.add((Variable) variable);
            }
            else if (variable.getClass() == ListEndCommand.class){

            }
            else{
                // TODO throw new exception, not a variable parameter
            }
        }
        
        if (getChildren().get(VARIABLES_LIST_NODE).getClass() != ListStartCommand.class | getChildren().get(COMMANDS_LIST_NODE).getClass() != ListStartCommand.class){
            //throw new exception
            //TODO throw exception if either of the two arent lists
        }
        
        ImmutableUserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, variables, (ListStartCommand) getChildren().get(COMMANDS_LIST_NODE));
        
        backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);
        setReturnValue(1);
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    public Command copy() {
        return new MakeUserInstructionCommand();
    }
}
