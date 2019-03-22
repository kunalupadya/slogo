package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class GroupEndCommand extends BasicCommand {

    public GroupEndCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) { }

    @Override
    public Command copy() {
        return new GroupEndCommand();
    }
}
