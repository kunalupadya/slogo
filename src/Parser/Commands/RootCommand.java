package Parser.Commands;

public class RootCommand extends Command{

    public RootCommand(){
        isConstant = false;
        numParameters = (int) Double.POSITIVE_INFINITY;
    }

    public void performAction(){
    }

}
