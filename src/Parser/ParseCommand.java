package Parser;

import GraphicsBackend.Turtle;
import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Turtle_Command.ListEndCommand;
import Parser.Commands.Turtle_Command.ListStartCommand;
import Parser.Commands.Turtle_Command.TextCommand;
import Parser.Commands.Variable;

import java.util.*;

/**
 * @author Louis Lee
 * @co-author Dhanush Madabusi
 */

public class ParseCommand {

    private final String whiteSpace = "\\s+";
    private String myLanguage;
    private ArrayList<Command> commandsList;
    private List<Token> tokensList;
    private List<Turtle> myTurtleList;
    private Map<String, String> commandMap;

    public ParseCommand(String consoleInput, List<Turtle> turtles,String commandLanguage, BackendController backendController){

        myLanguage = commandLanguage;
        myTurtleList = turtles;

        //TODO Make handleerror work
        if(consoleInput.equals(null) || consoleInput.equals("")){

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
        commandsList = stackCommand(translatedListOfWords, tokensList);

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


    private ArrayList<Command> stackCommand(String[] listOfWords, List<Token> tokensList) {
        ArrayList<Command> commandArrayList = new ArrayList<Command>();

        for (int a=0; a< listOfWords.length; a++){
            String word = listOfWords[a];
            Token token = tokensList.get(a);
            try {
                Class<?> clazz = Class.forName("Parser.Commands.Turtle_Command." + word + "Command");
                Object object = clazz.getConstructor().newInstance();
                Command newCommand = (Command) object;
                commandArrayList.add(newCommand);

            } catch (Exception e) {
//                    e.printStackTrace();
                Command newCommand;
                if (token == Token.LIST_START){
                    newCommand = new ListStartCommand();
                }
                else if (token == Token.LIST_END){
                    newCommand = (new ListEndCommand());
                }
                /*else if (token == Token.GROUP_START){
                    newCommand = new GroupStartCommand();
                }
                else if (token == Token.GROUP_END){
                    newCommand = new GroupEndCommand();
                }*/
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
                commandArrayList.add(newCommand);
                //TODO add userdefined command here
            }
        }
        return commandArrayList;
    }

}
