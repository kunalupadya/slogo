package Parser.Commands;

import Parser.BackendController;

/**
 * @author kunalupadya
 */
public class ListStartCommand extends BasicCommand {

    public ListStartCommand(){
        setNumParameters((int) Double.POSITIVE_INFINITY);
        isOutputCommand = false;
    }

    @Override
    protected void performAction(BackendController backendController) {
        setReturnValue(getChildren().size() - 1);
    }

    @Override
    public Command copy() {
        return new ListStartCommand();
    }
}
