package Parser.Commands;

public class ConstantCommand extends Command {

    public ConstantCommand(Double input){
        returnValue = input;
        isConstant = true;
        numParameters = 0;
    }

    public void performAction(){
    }

}
