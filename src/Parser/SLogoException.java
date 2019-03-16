package Parser;

/**
 * @author Dhanush Madabusi
 */
public abstract class SLogoException extends Exception{

    private String errorType;
    private static final long serialVersionUID = 1L;

    public SLogoException(String errorType, String error){
        super(error);
        this.errorType = errorType;

    }

    String getErrorType(){
        return errorType;
    }
}
