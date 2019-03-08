package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.Command;

import java.util.List;

public class GroupStartCommand extends Command {

    public static final int COMMAND_INDEX = 0;

    public GroupStartCommand(){
        isConstant = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
    }

    @Override
    protected void performAction(BackendController backendController) {
        Command command = myChildrenList.get(COMMAND_INDEX);
        int numParameters = command.getNumParameters();
        while (true){
            List<Command> commandList = command.getChildren();
            if (commandList.size() == numParameters && numParameters != 0){
                command.setIsConstant(false); //allows you to rerun the same program
                command.execute(backendController);
                command.getChildren().clear();
            }
            if (myChildrenList.size()>2){//2 comes from the command and the groupendcommand
                commandList.add(myChildrenList.remove(1));
            }
            else{
                if (!commandList.isEmpty()){
                    //TODO throw new error, improper number of parameters
                }
                break;
            }

        }
        returnValue = command.getReturnValue();
    }

    @Override
    public Command copy() {
        return new GroupStartCommand();
    }
}