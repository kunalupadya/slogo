package Parser;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Louis Lee
 * @co-author Dhanush Madabusi
 */

public class ParseCommand {

    private final String whiteSpace = "\\s+";
    private final String noInput = "";
    private String myLanguage;
    private ArrayList<Command> commandsList;
//    private HandleError handleError;
    private List<Token> tokensList;
    private List<Turtle> myTurtleList;
    private Map<String, String> commandMap;

    public ParseCommand(String consoleInput, List<Turtle> turtles,String commandLanguage, BackendController backendController){

        myLanguage = commandLanguage;
        myTurtleList = turtles;

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
//            handleError.noInputError();
        }

        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        System.out.println(refinedInput);
        String [] listOfWords = refinedInput.split(whiteSpace);
        System.out.println(listOfWords);
        
        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(myLanguage);

        //TODO: try catch block if command is not valid
        String[] translatedListOfWords = languageSetting.translateCommand(listOfWords);
        commandMap = languageSetting.makeReflectionMap();

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedListOfWords);
        commandsList = stackCommand(translatedListOfWords, myTurtleList, commandMap);
        System.out.println("commandlist is " + commandsList.size());

        //Execute Command
        ExecuteCommand executeCommand = new ExecuteCommand(commandsList, tokensList, backendController);
        executeCommand.runCommands();
    }

    private List<Token> addToTokenList(String[] translatedListOfWords){
        TokenConverter tokenConverter = new TokenConverter();
        List<Token> list = new ArrayList<>();
        for(String str: translatedListOfWords){
            list.add(tokenConverter.checkTypeOfInput(str));
        }
        return list;
    }


    private ArrayList<Command> stackCommand(String[] listOfWords, List<Turtle> turtleList, Map<String, String> commandMap) {
        ArrayList<Command> commandArrayList = new ArrayList<Command>();
        System.out.println(commandMap.keySet());
        System.out.println(commandMap.get("fd"));

        for (String word : listOfWords) {
            //System.out.println(commandMap.get(word));
            word = word.toLowerCase();
            if (commandMap.keySet().contains(word)) {
                try {
                    System.out.println("Parser.Commands.Turtle_Command." + commandMap.get(word) + "Command");
                    Class<?> clazz = Class.forName("Parser.Commands.Turtle_Command." + commandMap.get(word) + "Command");
                    Object object = clazz.getConstructor().newInstance();
                    Command newCommand = (Command) object;
                    commandArrayList.add(newCommand);

                } catch (Exception e) {
                    System.out.println("class not found");
                    //handleerror

                }
            }
            else{
                //TODO: @Dhanush : Add an error
                Command newCommand = new ConstantCommand(Double.parseDouble(word));
                commandArrayList.add(newCommand);
            }

        }
        return commandArrayList;
    }

}
