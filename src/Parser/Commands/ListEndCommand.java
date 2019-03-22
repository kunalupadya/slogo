package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ListEndCommand extends BasicCommand {

    public ListEndCommand(){
        setNumParameters(0);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {

    }

    @Override
    public Command copy() {
        return new ListEndCommand();
    }
}
