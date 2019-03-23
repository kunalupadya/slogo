package Parser;

import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Turtle_Command.*;
import Parser.Commands.Variable;
import java.util.*;

/**
 * This class receives user input through backendController, removes all comments, translates input into English, and
 * constructs list of commands based on Token types. It then constructs the parsingTree and executes all commands,
 * reporting errors if necessary.
 *
 * @author Louis Lee
 * @author Dhanush Madabusi
 */
public class ParseCommand {

    /**
     * refines the consoleInput and will make relevant command classes and executing the commands.
     * @param consoleInput: input from the console
     * @param commandLanguage : chosen language from the GUI
     * @param backendController: the backendController(parser) itself to parse all turtles
     */
    public ParseCommand(String consoleInput, String commandLanguage, BackendController backendController){
        if(consoleInput != null && !consoleInput.equals("")) {
            String refinedInput = removeComments(consoleInput);
            String[] listOfWords = refinedInput.toLowerCase().trim().split("\\s+");
            LanguageSetting languageSetting = new LanguageSetting(commandLanguage);
            String[] translatedListOfWords = languageSetting.translateCommand(listOfWords);
            var tokensList = addToTokenList(translatedListOfWords);
            var commandsList = stackCommand(translatedListOfWords, tokensList);
            try {
                ParsingTree parsingTree = new ParsingTree(commandsList, backendController);
                ExecuteCommand executeCommand = new ExecuteCommand(backendController, parsingTree);
                executeCommand.runCommands();
            }
            catch (SLogoException e){
                backendController.showErrorMessage(e.getErrorType() + ": " + e.getMessage());
            }
        }
    }

    private String removeComments(String input){
        String [] lineSplit = input.split("\n");
        StringBuilder refinedInput = new StringBuilder();
        for (int i = 0; i < lineSplit.length; i++){
            if (i != 0){
                refinedInput.append(" ");
            }
            String s = lineSplit[i];
            if (!s.contains("#")){
                refinedInput.append(s);
                continue;
            }
            int commentIndex = s.indexOf("#");
            refinedInput.append(s.substring(0, commentIndex));
        }
        return refinedInput.toString();
    }

    private List<Token> addToTokenList(String[] translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        List<Token> list = new ArrayList<>();
        for(String str: translatedListOfWords){
            list.add(tokenConverter.checkTypeOfInput(str));
        }
        return list;
    }


    private List<Command> stackCommand(String[] listOfWords, List<Token> tokensList) {
        List<Command> commandArrayList = new ArrayList<>();
        for (int a=0; a< listOfWords.length; a++){
            String word = listOfWords[a];
            Token token = tokensList.get(a);
            try {
                Class<?> clazz = Class.forName("Parser.Commands.Turtle_Command." + word + "Command");
                Object object = clazz.getConstructor().newInstance();
                Command newCommand = (Command) object;
                commandArrayList.add(newCommand);
            } catch (Exception e) {
                commandArrayList.add(determineCommandType(word, token));
            }
        }
        return commandArrayList;
    }

    private Command determineCommandType(String word, Token token){
        Command newCommand;
        if (token == Token.LIST_START){
            newCommand = new ListStartCommand();
        }
        else if (token == Token.LIST_END){
            newCommand = (new ListEndCommand());
        }
        else if (token == Token.GROUP_START){
            newCommand = new GroupStartCommand();
        }
        else if (token == Token.GROUP_END){
            newCommand = new GroupEndCommand();
        }
        else if (token == Token.VARIABLE){
            newCommand = new Variable(word.substring(1));
        }
        else{
            try{
                newCommand = new ConstantCommand(Double.parseDouble(word));
            }
            catch (NumberFormatException n){
                newCommand = new TextCommand(word);
            }
        }
        return newCommand;
    }
}
