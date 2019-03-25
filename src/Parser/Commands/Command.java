package Parser.Commands;

import GraphicsBackend.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the abstract class defines all base methods. All commands must extend this class.
 * @author kunalupadya
 * @author Louis Lee
 * @author Dhanush Madabusi
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

    /**
     * Returns whether a command can have unlimited parameters. Only arithmetic commands with two parameters, And, and
     * Or commands can truly have unlimited parameters.
     *
     * @return unlimitedParameters
     */
    public boolean canHaveUnlimitedParameters(){
        return unlimitedParameters;
    }

    /**
     * Returns whether command would output to console is it is only command run.
     *
     * @return isOutputCommand
     */
    public boolean getIsOutputCommand(){
        return isOutputCommand;
    }

    /**
     * Returns current number of children or command parameters.
     *
     * @return currentNumParameters
     */
    public int getCurrentNumParameters() {
        return currentNumParameters;
    }

    /**
     * Returns whether command has been evaluated already.
     *
     * @return isEvaluated
     */
    public boolean getIsEvaluated(){
        return isEvaluated;
    }

    /**
     * Sets whether command has been evaluated.
     *
     * @param constant whether command has been evaluated
     */
    public void setIsEvaluated(boolean constant) {
        isEvaluated = constant;
    }

    /**
     * Returns number of parameters the command needs.
     *
     * @return numParameters
     */
    public int getNumParameters(){
        return numParameters;
    }

    /**
     * Sets the number of parameters the command needs.
     *
     * @param numParameters numParameters
     */
    public void setNumParameters(int numParameters) {
        this.numParameters = numParameters;
    }

    /**
     * Returns returnValue of command.
     *
     * @return returnValue
     */
    public double getReturnValue() {
        return returnValue;
    }

    /**
     * Sets returnValue of command
     *
     * @param returnValue return value of command
     */
    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
        isEvaluated = true;
    }

    /**
     * Returns text of command, if any.
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    /**
     * Returns copy of command
     *
     * @return copy of command
     */
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

    /**
     * Adds command to list of children and increases number of current parameters for command.
     *
     * @param command command to be added to children
     */
    public void addChildren(Command command) {
            myChildrenList.add(command);
            currentNumParameters += 1;
    }

    /**
     * Gets list of children or commands list of parameters.
     *
     * @return myChildrenList
     */
    public List<Command> getChildren(){
        return myChildrenList;
    }

    protected double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getMyX() - point2.getMyX(), 2) + Math.pow(point1.getMyY() - point2.getMyY(), 2));
    }
}