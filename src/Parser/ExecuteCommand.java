package Parser;

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

    private static final String PARAMETERS_MISSING = "Parameters missing";
    private static final String WRONG_NUMBER_OF_PARAMETERS = "Wrong number of parameters";
    private static final int EXPRESSION_INDEX = 1;
    private Command headNode;
    private BackendController backendController;

    public ExecuteCommand(List<Command> commandsList, BackendController backendController) {
        ParsingTree parsingTree = new ParsingTree(commandsList, backendController);
        headNode = parsingTree.getRoot();
        this.backendController = backendController;
    }

    void runCommands(){
        //post traversal starting from headNode
        try {
            traverse(headNode);
        }
        catch (SyntaxError e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    private void traverse(Command node){
        if (node.getChildren().isEmpty()&node.getClass() != TextCommand.class){
            //leaf nodes, should return
            handleEmptyChildrenCommands(node);
            return;
        }
        if (node.getClass() == MakeUserInstructionCommand.class | node.getClass() == ListEndCommand.class){
            //this is the only class that is executed as it is parsed, so it does not need to be reparsed
            return;
        }
        if (node.getClass() == MakeVariableCommand.class){
            handleMakeVariableCommand(node);
        }
        if (node instanceof ControlCommand){
            handleControlCommand((ControlCommand) node);
            return;
        }
        traverseChildren(node);
        handleAfterGenerationOfChildren(node);
    }

    private void handleControlCommand(ControlCommand node) {
        node.setInitialExpression();
        if (node.getInitialExpression() != null){
            traverse(node.getInitialExpression());
            node.setLimit(node.getInitialExpression().getReturnValue());
        }
        while(node.shouldRunAgain()) {
            node.execute(backendController);
            if (node.getListToRun() != null) {
                handleListStartCommand(node.getListToRun());
                node.setReturnValue(node.getListToRun().getReturnValue());
            }
        }
    }

    private void handleListStartCommand(Command node) {
        traverseChildren(node);
    }

    private void handleAfterGenerationOfChildren(Command node) {
        if (node.getClass() == TextCommand.class){
            handleTextCommand(node);
        }
        else if (node.getNumParameters() == node.getChildren().size()){
            node.execute(backendController);
        }
        else if (node.getClass() == RootCommand.class){
            // do nothing, the root command should not throw an error
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);//TODO replace with another exception
        }
    }

    private void handleTextCommand(Command node) {
        node.execute(backendController);
        traverseChildren(node);
    }

    private void traverseChildren(Command node) {
        for (Command child : node.getChildren()) {
            traverse(child);
        }
    }

    private void handleMakeVariableCommand(Command node) {
        traverse(node.getChildren().get(EXPRESSION_INDEX));
        node.execute(backendController);
    }

    private void handleEmptyChildrenCommands(Command node) {
        if (node.getIsConstant()){
            // do nothing, the return value is already present
        }
        else if (node.getNumParameters() == 0){
            node.execute(backendController);
        }
        else{
            throw new SyntaxError(PARAMETERS_MISSING);
        }
    }
}
