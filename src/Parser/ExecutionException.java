package Parser;

/**
 * This Exception class is for errors that occur while executing commands.
 *
 * @author Dhanush Madabusi
 */
public class ExecutionException extends SLogoException{

    /**
     * ExecutionException Constructor
     *
     * @param error error message
     */
    public ExecutionException(String error){
        super("Execution Error", error);
    }
}
