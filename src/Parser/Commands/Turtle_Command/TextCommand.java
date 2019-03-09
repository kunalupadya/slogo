package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

import java.util.List;
import java.util.Optional;


/**
 * @author kunalupadya
 */
public class TextCommand extends Command {

    public static final int COMMANDS = 3;

    public TextCommand(String text){
<<<<<<< HEAD
        setNumParameters(0);
        setText(text);
=======
        isOutputCommand = false;
        isEvaluated = false;
        numParameters = 0;
        this.text = text;
>>>>>>> a1a6c60437162d2d87d90f7a1b81c253f7208a10
    }

    @Override
    protected void performAction(BackendController backendController) {
        Optional<ImmutableUserDefinedCommand> userDefinedCommand =  backendController.getUserDefinedCommand(getText());
        if (userDefinedCommand.isPresent()){

            ImmutableUserDefinedCommand command = userDefinedCommand.get();
            UserDefinedCommand copyOfCommand = (UserDefinedCommand) command.copy();
            List<Variable> variables = copyOfCommand.getVariables();

            for (int k = 0; k<getChildren().size(); k++){
                Variable currentVariable = variables.get(k);
                currentVariable.setReturnValue(getChildren().get(k).getReturnValue());
            }

            getChildren().clear();

            getChildren().add(copyOfCommand);

            backendController.addUserDefinedCommandToStack(copyOfCommand);
        }
        else {
            // throw new TODO create exception, command not defined
        }
    }

    @Override
    public Command copy() {
        return new TextCommand(getText());
    }
}