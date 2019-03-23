package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.Commands.Variable;
import Parser.ExecutionException;
import Parser.SLogoException;
import java.util.List;
import java.util.Optional;

/**
 * Command handles any alphabet text input that is not recognized in pre-defined set of commands.
 *
 * @author kunalupadya
 * @author Dhanush Madabusi
 */
public class TextCommand extends BasicCommand {

    /**
     * Command Constructor
     */
    public TextCommand(String text){
        setNumParameters(0);
        setText(text);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        Optional<ImmutableUserDefinedCommand> userDefinedCommand =  backendController.getUserDefinedCommand(getText());
        if (userDefinedCommand.isPresent()){
            ImmutableUserDefinedCommand command = userDefinedCommand.get();
            UserDefinedCommand copyOfCommand = (UserDefinedCommand) command.copy();
            List<Variable> variables = copyOfCommand.getVariables();

            for (int k = 0; k < getChildren().size(); k++){
                Variable currentVariable = variables.get(k);
                var setParam = new MakeVariableCommand();
                setParam.addChildren(currentVariable);
                setParam.addChildren(getChildren().get(k));
                setParam.execute(backendController);
            }

            getChildren().clear();
            getChildren().add(copyOfCommand);
            backendController.addUserDefinedCommandToStack(copyOfCommand);
            setReturnValue(0);
        }
        else {
            throw new ExecutionException(getText() + " has not been defined");
        }
    }

    /**
     * Returns copy of command
     *
     * @return copy of command
     */
    @Override
    public Command copy() {
        return new TextCommand(getText());
    }
}