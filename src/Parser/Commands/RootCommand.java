package Parser.Commands;

public class RootCommand extends Command{

    protected double execute(double a){
        return Math.atan(a);
    }

    public int getNumParameters(){
        return 0;
    }

}
