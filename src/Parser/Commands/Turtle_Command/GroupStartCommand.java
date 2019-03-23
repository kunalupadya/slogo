package Parser.Commands.Turtle_Command;

import Parser.BackendController;
import Parser.Commands.BasicCommand;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.ExecutionException;
import Parser.SLogoException;

/**
 * Command allows for unlimited parameters using the Group syntax.
 *
 * @author Dhanush Madabusi
 */
public class GroupStartCommand extends BasicCommand {

    private static final int COMMAND_INDEX = 0;
    private Command groupMainCom;
    private int groupIndex = 1;
    private Command commandToRun;
    private boolean moreParametersLeft = true;

    /**
     * Command Constructor
     */
    public GroupStartCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) throws SLogoException {
        if (commandToRun != null && groupMainCom.canHaveUnlimitedParameters()){
            ConstantCommand firstParam = new ConstantCommand(commandToRun.getReturnValue());
            commandToRun = groupMainCom.copy();
            commandToRun.addChildren(firstParam);
        }
        else {
            commandToRun = groupMainCom.copy();
        }
        int numParameters = groupMainCom.getNumParameters();
        while(commandToRun.getCurrentNumParameters() < numParameters){
            Command nextChild = getChildren().get(groupIndex);
            if (nextChild.getClass() == GroupEndCommand.class){
                throw new ExecutionException("Group command is missing parameters");
            }
            commandToRun.addChildren(nextChild);
            groupIndex++;
        }
        if (getChildren().get(groupIndex).getClass() == GroupEndCommand.class){
            moreParametersLeft = false;
        }
    }

    public void setUpGroupMainCom(){
        groupMainCom = getChildren().get(COMMAND_INDEX);
    }

    public Command getCommandToRun(){
        return commandToRun;
    }

    public boolean areMoreParametersLeft(){
        return moreParametersLeft;
    }

}