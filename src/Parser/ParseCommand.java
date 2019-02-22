package Parser;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private String refinedInput;
    private ParsingTree parsingTree;

    public ParseCommand(String consoleInput){
        RemoveCurrent removeCurrent = new RemoveCurrent(consoleInput);
        refinedInput = removeCurrent.getOutput();
        parsingTree = new ParsingTree();
    }
}
