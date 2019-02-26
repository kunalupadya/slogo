package Parser;

import GUI.Controls.SwitchLanguages;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private String emptySpace = " ";
    private String noInput = "";
    private String myLanguage;
    private ArrayList<Command> commandsList;
    private HandleError handleError;
    private ArrayList<Token> tokensList;
    private String[] translatedListOfWords;


    public ParseCommand(String consoleInput){

        //set Language;
        myLanguage = SwitchLanguages.getLanguage();

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
            handleError.noInputError();
        }

        //remove comments
        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String[] listOfWords = refinedInput.split(emptySpace);

        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(myLanguage);
        translatedListOfWords = languageSetting.translateCommand(listOfWords);

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedListOfWords);
        commandsList = stackCommand(listOfWords);

        //Execute Command
        ExecuteCommand executeCommand = new ExecuteCommand(commandsList, tokensList);
        executeCommand.runCommands();
    }

    private ArrayList<Token> addToTokenList(String[] translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        ArrayList<Token> list = new ArrayList<Token>();
        for(int a=0; a<translatedListOfWords.length; a++){
            list.add(tokenConverter.checkTypeOfInput(translatedListOfWords[a]));
            }
        return list;
        }


    public ArrayList<Command> stackCommand(String[] listOfWords){
        ArrayList<Command> list = new ArrayList<Command>();
        CommandFactory commandFactory = new CommandFactory();
        for(int a=0 ; a<listOfWords.length ; a++){
            Command newCommand = commandFactory.getCommand(listOfWords[a]);
            list.add(newCommand);
        }
        return list;
        }
}
