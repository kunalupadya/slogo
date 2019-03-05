package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;

import java.util.Optional;

public class TextCommand extends Command {

    public static final int COMMANDS = 3;

    public TextCommand(String text){
        isConstant = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
        this.text = text;

    }

    @Override
    protected void performAction(BackendController backendController) {
        Optional<UserDefinedCommand> userDefinedCommand =  backendController.getUserDefinedCommand(text);
        if (userDefinedCommand.isPresent()){

            UserDefinedCommand command = userDefinedCommand.get();

            numParameters = command.getVariables().size();

            for (Command child: myChildrenList){

            }

            command.getChildren().get(COMMANDS);
        }
        else {
            // throw new TODO create exception, command not defined
        }
    }
}
