package Parser;

import GraphicsBackend.Turtle;

import Main.BackendController;
import Parser.Commands.Command;
import Parser.Commands.RootCommand;
import Parser.Commands.Turtle_Command.*;
import javafx.scene.control.Alert;

import java.util.List;

/**
 * @author Kunal Upadya
 * @author Louis Lee
 */

public class ExecuteCommand {

    public static final String PARAMETERS_MISSING = "Parameters missing";
    public static final String WRONG_NUMBER_OF_PARAMETERS = "Wrong number of parameters";
    public static final int EXPRESSION_INDEX = 1;
    private Command headNode;
    private BackendController backendController;

    public ExecuteCommand(List<Command> commandsList, BackendController backendController) {
        ParsingTree parsingTree = new ParsingTree(commandsList, backendController);
        headNode = parsingTree.getRoot();
        this.backendController = backendController;
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
        if (node.getChildren().isEmpty()&node.getClass() != TextCommand.class){
            handleEmptyChildrenCommands(node);
            return;
        }
        if (node.getClass() == MakeUserInstructionCommand.class | node.getClass() == ListEndCommand.class){
            //this is the only class that is executed as it is parsed, so it does not need to be reparsed
            return;
        }
        if (node.getClass() == MakeVariableCommand.class){
            traverse(node.getChildren().get(EXPRESSION_INDEX));
            node.execute(backendController);
        }
        if (node.getClass() == ListStartCommand.class){
            for (Command child: node.getChildren()){
                traverse(child);
            }
            return;
        }
        for (Command child: node.getChildren()){
            traverse(child);
        }
        if (node.getClass() == TextCommand.class){
            node.execute(backendController);
            System.out.println("hi");
            for (Command child: node.getChildren()){
                traverse(child);
            }
        }
        else if (node.getNumParameters() == node.getChildren().size()){
            node.execute(backendController);
            System.out.println(node.getReturnValue());
        }

        else if (node.getClass() == RootCommand.class){
            return;
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);
        }
    }

    private void handleEmptyChildrenCommands(Command node) {
        if (node.getIsConstant()){
            return;
        }
        else if (node.getNumParameters() == 0){
            node.execute(backendController);
        }
        else{
            throw new SyntaxError(PARAMETERS_MISSING);
        }
        return;
    }
}
