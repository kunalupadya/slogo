package Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private String emptySpace = " ";
    private String noInput = "";
    private TokenConverter tokenConverter;
    private ArrayList<Command> commandArrayList;
    private Set<String> listOfCommands;
    private HandleError handleError;
    private ArrayList<Token> listOfTokens;
    private ExecuteCommand executeCommand;


    public ParseCommand(String consoleInput){

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
            handleError.noInputError();
        }

        //remove comments
        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String[] listOfWords = refinedInput.split(emptySpace);

        //convert word into tokens and check validity
        addToTokenList(listOfWords);

        //make list of commands
        stackCommand(listOfWords);
        executeCommand.runCommands();

    }

    private void addToTokenList(String[] listOfWords){
        for(int a=0; a<listOfWords.length; a++){
            listOfTokens.add(tokenConverter.checkTypeOfInput(listOfWords[a]));
            if(listOfTokens.get(a) == Token.ERROR){
                String[] newListOfWords = Arrays.copyOfRange(listOfWords, 0, a);
                stackCommand(newListOfWords);
                handleError.syntaxError(listOfWords[a]);
                //need a line here to end the process
                break;
            }
        }
    }

    public void stackCommand(String[] listOfWords){
        for(int a=0 ; a<listOfWords.length ; a++){
            //see if such command exists
            try {
                Class.forName("Command/" + listOfWords[a]);
            }
            catch (ClassNotFoundException e){
                handleError.undefinedCommandErrors(listOfWords[a]);
            }
            //add command to the list
            commandArrayList.add((Command) listOfWords[a]);
            }
        }
}
