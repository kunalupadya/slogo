package Parser;

import GraphicsBackend.Turtle;
import Parser.Commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Map<String[], String> commandMap;


    public ParseCommand(String consoleInput, List<Turtle> turtles){
        //set Language;
//        myLanguage = SwitchLanguages.getLanguage();
        myLanguage = "English";
        myTurtleList = turtles;

        //user typed empty string or didn't type anything
        if(consoleInput.equals(noInput) || consoleInput == null){
//            handleError.noInputError();
        }

        RemoveComment removeComment = new RemoveComment(consoleInput);
        String refinedInput = removeComment.getOutput();
        String [] listOfWords = refinedInput.split(whiteSpace);
        
        //translate the input into default language
        LanguageSetting languageSetting = new LanguageSetting(myLanguage);

        //TODO: try catch block if command is not valid
        String[] translatedListOfWords = languageSetting.translateCommand(listOfWords);
        commandMap = languageSetting.makeReflectionMap();
        System.out.println(commandMap.keySet());

        //convert word into tokens and check validity
        tokensList = addToTokenList(translatedListOfWords);
        commandsList = stackCommand(translatedListOfWords, myTurtleList, commandMap);

        //Execute Command
        ExecuteCommand executeCommand = new ExecuteCommand(commandsList, tokensList);
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


    private ArrayList<Command> stackCommand(String[] listOfWords, List<Turtle> turtleList, Map<String[], String> commandMap){
        ArrayList<Command> commandArrayList = new ArrayList<Command>();

        for(String word: listOfWords){
            for(String[] list1: commandMap.keySet()){
                ArrayList<String> list2 = new ArrayList<>(Arrays.asList(list1));
                if(list2.contains(word)){
                    try{
                        Class<?> clazz = Class.forName("Parser.Commands.TurtleCommand." + commandMap.get(word) + "Command");
                        Object object = clazz.getConstructor().newInstance();
                        Command newCommand =(Command) object;
                        newCommand.setMyTurtleList(turtleList);
                        System.out.println("class found");
                        commandArrayList.add(newCommand);

                    }
                    catch (Exception e) {
                        System.out.println("class not found");
                        e.printStackTrace();
                    }

                }
            }

        }
        return commandArrayList;
    }

}
