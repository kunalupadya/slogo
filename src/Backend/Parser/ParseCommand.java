package Backend.Parser;

import Backend.CommandFactory;
import Backend.ExecuteCommand;
import GUI.Controls.SwitchLanguages;
import Backend.Commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis Lee
 * @co-author Dhanush Madabusi
 */

public class ParseCommand {

    private final String whiteSpace = "\\s+";
    private final String noInput = "";
    private LanguageSetting langSetting;
    private String myLanguage;
    private ArrayList<Command> commandsList;
    private HandleError handleError;
    private List<Token> tokensList;


    public ParseCommand (String language){
        myLanguage = language;
        langSetting = new LanguageSetting(language);
    }

    public Expression void parseInput(){

    }

    public ParseCommand(String consoleInput){

        //set Language;

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
            handleError.noInputError();
        }

        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String [] listOfWords = refinedInput.split(whiteSpace);
        
        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(myLanguage);
        //TODO: try catch block if command is not valid
        String[] translatedListOfWords = languageSetting.translateCommand(listOfWords);

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedListOfWords);
    }

    private List<Token> addToTokenList(String[] translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        List<Token> list = new ArrayList<>();
        for(String str: translatedListOfWords){
            list.add(tokenConverter.checkTypeOfInput(str));
        }
        return list;
    }

    public Expression parseInput(String userInput) {
    }

    /**
    //TODO: this method should create complete list of Commands that Execute Command merely runs using Command tree
    //implementation is wrong currently
    private ArrayList<Command> stackCommand(String[] listOfWords){
        ArrayList<Command> list = new ArrayList<Command>();
        CommandFactory commandFactory = new CommandFactory();
        for(String word: listOfWords){
            //TODO: error to be fixed after command implementation
            Command newCommand = commandFactory.getCommand(word);
            list.add(newCommand);
        }
        return list;
    }
     **/

}
