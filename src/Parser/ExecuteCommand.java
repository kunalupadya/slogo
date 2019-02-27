package Parser;


import Parser.Commands.Command;
import javafx.scene.control.Alert;

import java.util.ArrayList;

/**
 * @author Kunal Upadya
 * @author Louis Lee
 */

public class ExecuteCommand {

    public static final String PARAMETERS_MISSING = "Parameters missing";
    public static final String WRONG_NUMBER_OF_PARAMETERS = "Wrong number of parameters";
    private ArrayList<Command> myCommandsList;
    private ArrayList<Token> myTokensList;
    Command headNode;

    public ExecuteCommand(ArrayList<Command> commandsList, ArrayList<Token> TokensList){
        myCommandsList = commandsList;
        myTokensList = TokensList;
        ParsingTree parsingTree = new ParsingTree(myCommandsList, myTokensList);
        headNode = parsingTree.getRoot();
    }

    public void runCommands(){
        //post traversal starting from headNode
        try {
            traverse(headNode);
        }
        catch (SyntaxError e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    public void traverse(Command node){
        if (node.getChildren().isEmpty()){
            if (node.numParameters() == 0){
                node.execute();
            }
            else{
                throw new SyntaxError(PARAMETERS_MISSING);
            }
            return;
        }
        for (Command child: node.getChildren()){
            traverse(child);
        }

        if (node.numParameters() == node.getChildren().size()){
            node.execute();
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);
        }
    }
}
