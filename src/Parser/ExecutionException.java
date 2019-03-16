package Parser;

/**
 * @author Dhanush Madabusi
 */
public class ExecutionException extends SLogoException{

    public ExecutionException(String error){
        super("Execution Error", error);
    }
}
