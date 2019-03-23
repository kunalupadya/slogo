package Parser;

/**
 * This Exception class is for errors that occur while parsing user input.
 *
 * @author Dhanush Madabusi
 */
public class ParserException extends SLogoException{

    /**
     * ParserException Constructor
     *
     * @param error error message
     */
    public ParserException(String error){
        super("Parsing Error", error);
    }
}
