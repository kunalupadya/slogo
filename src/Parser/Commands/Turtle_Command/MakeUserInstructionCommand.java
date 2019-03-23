package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.Commands.Variable;
import Parser.ParserException;
import Parser.SLogoException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kunalupadya
 */
public class MakeUserInstructionCommand extends BasicCommand {

    private static final int NAME_NODE = 0;
    private static final int VARIABLES_LIST_NODE = 1;
    private static final int COMMANDS_LIST_NODE = 2;
    private List<Variable> variables = new ArrayList<>();

    public MakeUserInstructionCommand(){
        setNumParameters(3);
        isOutputCommand = false;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        setReturnValue(0);
        String name = getChildren().get(NAME_NODE).getText();
        if (getChildren().get(VARIABLES_LIST_NODE).getClass() != ListStartCommand.class | getChildren().get(COMMANDS_LIST_NODE).getClass() != ListStartCommand.class){
            throw new ParserException("UserDefined Command " + name + " is missing one or more List parameters");
        }
        for (Command variable: getChildren().get(VARIABLES_LIST_NODE).getChildren()) {
            if (variable.getClass() == Variable.class) {
                variables.add((Variable) variable);
            }
            else if (variable.getClass() == ListEndCommand.class){
                break;
            }
            else{
                throw new ParserException("Expected a variable parameter");
            }
        }
        ImmutableUserDefinedCommand newUserDefinedCommand = new UserDefinedCommand(name, variables, (ListStartCommand) getChildren().get(COMMANDS_LIST_NODE));
        backendController.addNewUserDefinedCommand(name, newUserDefinedCommand);
        setReturnValue(1);
    }
}
