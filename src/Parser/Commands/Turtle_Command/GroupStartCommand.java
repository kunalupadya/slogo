package Parser.Commands.Turtle_Command;

import GraphicsBackend.Turtle;
import Parser.BackendController;
import Parser.Commands.Command;

import java.util.List;

/**
 * @author kunalupadya
 */
public class GroupStartCommand extends Command {

    private static final int COMMAND_INDEX = 0;

    public GroupStartCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController, Turtle turtle) {
        Command command = getChildren().get(COMMAND_INDEX);
        int numParameters = command.getNumParameters();
        while (true){
            List<Command> commandList = command.getChildren();
            if (commandList.size() == numParameters && numParameters != 0){
                command.setIsEvaluated(false); //allows you to rerun the same program
                command.execute(backendController, turtle);
                command.getChildren().clear();
            }
            if (getChildren().size() > 2){//2 comes from the command and the groupendcommand
                commandList.add(getChildren().remove(1));
            }
            else{
                if (!commandList.isEmpty()){
                    //TODO throw new error, improper number of parameters
                }
                break;
            }
        }
        setReturnValue(command.getReturnValue());
    }

    @Override
    public Command copy() {
        return new GroupStartCommand();
    }
}