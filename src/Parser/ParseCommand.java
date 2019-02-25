package Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private String defaultLanguage = "English";
    private String emptySpace = " ";
    private String noInput = "";
    private TokenConverter tokenConverter;
    private ArrayList<Command> commandArrayList;
    private Set<String> listOfCommands;
    private HandleError handleError;
    private ArrayList<Token> listOfTokens;
    private ExecuteCommand executeCommand;
    private String[] newListOfWords;


    public ParseCommand(String consoleInput, String language){

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
            handleError.noInputError();
        }

        //remove comments
        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String[] listOfWords = refinedInput.split(emptySpace);

        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(language);
        String[] translatedListOfWords = languageSetting.translateCommand(listOfWords);

        //convert word into tokens and check validity
        addToTokenList(translatedListOfWords);

        //make list of commands
        if(newListOfWords == null){stackCommand(translatedListOfWords);}
        executeCommand.runCommands(commandArrayList);
    }

    private void addToTokenList(String[] translatedListOfWords){
        for(int a=0; a<translatedListOfWords.length; a++){
            listOfTokens.add(tokenConverter.checkTypeOfInput(translatedListOfWords[a]));
            if(listOfTokens.get(a) == Token.ERROR){
                newListOfWords = Arrays.copyOfRange(translatedListOfWords, 0, a);
                stackCommand(newListOfWords);
                handleError.syntaxError(translatedListOfWords[a]);
                //need a line here to end the process
                return;
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
