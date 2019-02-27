package Parser;

import GUI.Controls.SwitchLanguages;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Louis Lee
 */

public class ParseCommand {

    private final String newLine = "\\n+";
    private final String whiteSpace = "\\s+";
    private final String noInput = "";
    private String myLanguage;
    private ArrayList<Command> commandsList;
    private HandleError handleError;
    private List<List<Token>> tokensList;


    public ParseCommand(String consoleInput){

        //set Language;
        myLanguage = SwitchLanguages.getLanguage();

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
            handleError.noInputError();
        }
        List<String[]> refinedLinesOfWords = cleanUpInput(consoleInput);
        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(myLanguage);
        //TODO: try catch block if command is not valid
        List<String[]> translatedLinesOfWords = languageSetting.translateCommand(refinedLinesOfWords);

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedLinesOfWords);
        commandsList = stackCommand(translatedLinesOfWords);

        //Execute Command
        ExecuteCommand executeCommand = new ExecuteCommand(commandsList, tokensList);
        executeCommand.runCommands();
    }

    private List<String[]> cleanUpInput(String consoleInput) {
        //remove comments
        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        List<String> lineSplit = new ArrayList<>(Arrays.asList(refinedInput.split(newLine)));
        List<String[]> refinedLines = new ArrayList<>();
        for (String str: lineSplit){
            if (str.trim().length() > 0){
                refinedLines.add(str.trim().split(whiteSpace));
            }
        }
        return refinedLines;
    }

    private List<List<Token>> addToTokenList(List<String[]> translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        List<List<Token>> list = new ArrayList<>();
        for(String [] line : translatedListOfWords){
            List<Token> tokenLine = new ArrayList<>();
            for (String str: line) {
                tokenLine.add(tokenConverter.checkTypeOfInput(str));
            }
            list.add(tokenLine);
        }
        return list;
    }

    //TODO: this method should create complete list of Commands that Execute Command merely runs using Command tree
    //implementation is wrong currently
    private ArrayList<Command> stackCommand(List<String[]> linesOfWords){
        ArrayList<Command> list = new ArrayList<>();
        CommandFactory commandFactory = new CommandFactory();
        for(String [] line: linesOfWords){
            //TODO: error to be fixed after command implementation
            Command newCommand = commandFactory.getCommand(str);
            list.add(newCommand);
        }
        return list;
    }
}
