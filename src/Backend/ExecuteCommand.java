package Backend;


<<<<<<< HEAD:src/Backend/ExecuteCommand.java
import Backend.Commands.Command;
import Backend.Parser.ParsingTree;
import Backend.Parser.SyntaxError;
import Backend.Parser.Token;
=======
import Parser.Commands.Command;
import Parser.Commands.RootCommand;
>>>>>>> 75d29976848d91b951c5ed2c23b7952b782894c5:src/Parser/ExecuteCommand.java
import javafx.scene.control.Alert;

import java.util.List;

/**
 * @author Kunal Upadya
 * @author Louis Lee
 */

public class ExecuteCommand {

    public static final String PARAMETERS_MISSING = "Parameters missing";
    public static final String WRONG_NUMBER_OF_PARAMETERS = "Wrong number of parameters";
    private List<Command> myCommandsList;
    private List<Token> myTokensList;
    RootCommand headNode;

    public ExecuteCommand(List<Command> commandsList, List<Token> TokensList){
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
            if (node.getNumParameters() == 0){
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

        if (node.getNumParameters() == node.getChildren().size()){
            node.execute();
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);
        }
    }
}
