package Parser.Commands.Boolean;

public abstract class BooleanCommand extends Command {

    protected int returnValue(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    protected int numParameters();
}
