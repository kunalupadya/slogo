package Parser;

import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Turtle_Command.*;
import Parser.Commands.Variable;
import java.util.*;

/**
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class ParseCommand {

    /**
     *
     * @param consoleInput: input from the console
     * @param commandLanguage : chosen language from the GUI
     * @param backendController: the backendcontroller(parser) itself to parse all turtles
     */
    public ParseCommand(String consoleInput, String commandLanguage, BackendController backendController){

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
            refinedInput.append(s, 0, commentIndex);

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
            Command newCommand;
            if(token == Token.Command) {
                try {
                    Class<?> clazz = Class.forName("Parser.Commands.Turtle_Command." + word + "Command");
                    Object object = clazz.getConstructor().newInstance();
                    newCommand = (Command) object;
                } catch (Exception e) {
                    newCommand = new TextCommand(word);
                }
            }
            else if(token == Token.Variable) {
                newCommand = new Variable(word.substring(1));
            }
            else if(token == Token.Constant){
                newCommand = new ConstantCommand(Double.parseDouble(word));
            }
            else{
                try {
                    Class<?> clazz = Class.forName("Parser.Commands." + token.toString() + "Command");
                    Object object = clazz.getConstructor().newInstance();
                    newCommand = (Command) object;
                    commandArrayList.add(newCommand);
                } catch (Exception e) {
                    newCommand = new TextCommand(word);
                }
            }
            commandArrayList.add(newCommand);
            }
        return commandArrayList;
    }

}
