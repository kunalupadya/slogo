package Parser;


import GraphicsBackend.Turtle;
import Parser.Commands.Command;
import Parser.Commands.RootCommand;
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
    private List<Turtle> myTurtleList;
    Command headNode;

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
            if (node.getIsConstant()){
                return;
            }
            else if (node.getNumParameters() == 0){
                node.performAction();
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
            System.out.println(node.getReturnValue());
        }
        else if (node.getClass() == RootCommand.class){
            return;
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);
        }
    }
}
