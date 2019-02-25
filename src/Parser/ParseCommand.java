package Parser;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private String defaultLanguage = "English";
    private String emptySpace = " ";
    private String noInput = "";
    private TokenConverter tokenConverter;
    private ArrayList<Command> commandsList;
    private Set<String> listOfCommands;
    private HandleError handleError;
    private ArrayList<Token> tokensList;
    private String[] translatedListOfWords;


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
        translatedListOfWords = languageSetting.translateCommand(listOfWords);

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedListOfWords);
        commandsList = stackCommand(listOfWords);

        //Execute Command
        ExecuteCommand executeCommand = new ExecuteCommand(commandsList, tokensList);
        executeCommand.runCommands();
    }

    private ArrayList<Token> addToTokenList(String[] translatedListOfWords){
        ArrayList<Token> list = new ArrayList<Token>();
        for(int a=0; a<translatedListOfWords.length; a++){
            list.add(tokenConverter.checkTypeOfInput(translatedListOfWords[a]));
            }
        return list;
        }


    public ArrayList<Command> stackCommand(String[] listOfWords){
        ArrayList<Command> list = new ArrayList<Command>();
        for(int a=0 ; a<listOfWords.length ; a++){
            //see if such command exists
            try {
                Class.forName("Command/" + listOfWords[a]);
            }
            catch (ClassNotFoundException e){
                handleError.undefinedCommandErrors(listOfWords[a]);
            }
            //add command to the list
            list.add((Command) listOfWords[a]);
            }
        return list;
        }
}
