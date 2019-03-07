package Parser.Commands.Turtle_Command;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.Variable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TextCommand extends Command {

    public static final int COMMANDS = 3;

    public TextCommand(String text){
        isConstant = false;
        numParameters = 0;
        this.text = text;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Optional<UserDefinedCommand> userDefinedCommand =  backendController.getUserDefinedCommand(text);
        if (userDefinedCommand.isPresent()){

            UserDefinedCommand command = userDefinedCommand.get();
            UserDefinedCommand copyOfCommand = (UserDefinedCommand) command.copy();
            List<Variable> variables = copyOfCommand.getVariables();

            for (int k = 0; k<myChildrenList.size(); k++){
                Variable currentVariable = variables.get(k);
                currentVariable.setReturnValue(myChildrenList.get(k).getReturnValue());
            }

            myChildrenList.clear();

            myChildrenList.add(copyOfCommand);

            backendController.addUserDefinedCommandToStack(copyOfCommand);
        }
        else {
            // throw new TODO create exception, command not defined
        }
    }

    @Override
    public Command copy() {
        return new TextCommand(text);
    }
}

//    UserDefinedCommand command = userDefinedCommand.get();
//    UserDefinedCommand newCommand = (UserDefinedCommand) command.copy();
//    for (int k = 0; k<newCommand.getVariables().size(); k++){
//        Variable variable = newCommand.getVariables().get(k);
//        currCommand = commandsList.remove(FIRST);
//        currToken = tokensList.remove(FIRST);
//        if (currCommand.getClass() != ConstantCommand.class){
//            //throw new TODO Add error missing parameters
//        }
//    }






/*parent.addChildren(n);*/
// TODO COPY THE TREE AND ADD IT HERE
//                    int numParameters = command.getNumParameters();
//                    for (Command child: myChildrenList){
//
//                    }
//
//                    command.getChildren().get(COMMANDS);