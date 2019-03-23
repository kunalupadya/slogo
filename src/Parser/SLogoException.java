package Parser;

/**
 * This abstract class is extended by all Exception classes.
 *
 * @author Dhanush Madabusi
 */
public abstract class SLogoException extends Exception{

    private String errorType;
    private static final long serialVersionUID = 1L;

    /**
     * SLogoException Constructor
     *
     * @param errorType type of error object
     * @param error     error message
     */
    public SLogoException(String errorType, String error){
        super(error);
        this.errorType = errorType;

    }

    String getErrorType(){
        return errorType;
    }
}
