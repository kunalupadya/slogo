package Parser.Commands;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for all commands. This is the abstract class that all ohter commands must extend
 * @author kunalupadya
 * @author Louis Lee
 */
public abstract class Command{

    private List<Command> myChildrenList = new ArrayList<>();
    private boolean isEvaluated = false;
    private double returnValue;
    private String text;
    private int numParameters;
    private int currentNumParameters = 0;
    protected boolean isOutputCommand;
    protected boolean unlimitedParameters = false;

    public Command(){
    }

    public boolean canHaveUnlimitedParameters(){
        return unlimitedParameters;
    }

    public boolean getIsOutputCommand(){
        return isOutputCommand;
    }

    public int getCurrentNumParameters() {
        return currentNumParameters;
    }

    public boolean getIsEvaluated(){
        return isEvaluated;
    }

    public void setIsEvaluated(boolean constant) {
        isEvaluated = constant;
    }

    public int getNumParameters(){
        return numParameters;
    }

    public void setNumParameters(int numParameters) {
        this.numParameters = numParameters;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
        isEvaluated = true;
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public List<Command> getChildren() {
        return myChildrenList;

    }

    public void addChildren(Command command) {
            myChildrenList.add(command);
            currentNumParameters += 1;
    }

    public Command copy(){
        Command newCommand;
        try {
            Class<?> clazz = Class.forName(this.getClass().getName());
            Object object = clazz.getConstructor().newInstance();
            newCommand = (Command) object;
        }
        catch (Exception e){
            //Will never reach this part
            newCommand = new RootCommand();
        }
        return newCommand;
    }

}