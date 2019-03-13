package Parser;

import GraphicsBackend.Turtle;
import Parser.Commands.*;
import Parser.Commands.Turtle_Command.*;
import javafx.scene.control.Alert;

import java.util.*;

/**
 * @author Kunal Upadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class ExecuteCommand {

    private static final String PARAMETERS_MISSING = "Parameters missing";
    private static final String WRONG_NUMBER_OF_PARAMETERS = "Wrong number of parameters";
    private static final int EXPRESSION_INDEX = 1;
    private static final int COMMAND_INDEX = 0;
    private RootCommand headNode;
    private RootCommand lastExecutedCopy;
    private BackendController backendController;
    private Turtle currTurtle;
    private boolean isASubCommand = false;

    public ExecuteCommand(List<Command> commandsList, BackendController backendController) {
        ParsingTree parsingTree = new ParsingTree(commandsList, backendController);
        headNode = (RootCommand) parsingTree.getRoot();
        this.backendController = backendController;
    }

    void executeAllTurtles(){
        boolean outputToConsole = false;
        if (headNode.getChildren().size() == 1 && headNode.getChildren().get(0).getIsOutputCommand()){
            outputToConsole = true;
        }
        Queue<Turtle> turtlesToExecute = new LinkedList<>();
        while(true){
            List<Turtle> turtleList = backendController.getMyTurtles();
            for (Turtle t: turtleList){
                if (!turtlesToExecute.contains(t)){
                    turtlesToExecute.add(t);
                }
            }
            if (turtlesToExecute.isEmpty()){
                break;
            }
            currTurtle = turtlesToExecute.poll();
            lastExecutedCopy = copyTree(headNode);
            runCommands(lastExecutedCopy);
        }
        if (outputToConsole){
            handleConsoleOutput();
        }
    }

    private void handleConsoleOutput() {
        Command outputCommand = lastExecutedCopy.getChildren().get(0);
        String output = "Result: ";
        if (outputCommand instanceof BooleanCommand || outputCommand instanceof IsPenDownCommand ||
                outputCommand instanceof IsShowingCommand){
            if (outputCommand.getReturnValue() == 1){
                output += "TRUE";
            }
            else{
                output += "FALSE";
            }
        }
        else{
            output += String.valueOf(outputCommand.getReturnValue());
        }
        backendController.outputResultToConsole(output);
    }

    private void runCommands(RootCommand rootCopy) {
        //post traversal starting from headNode
        try {
            traverse(rootCopy);
        } catch (SyntaxError e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }

    }

    private void traverse(Command node){
        if (node.getIsEvaluated()){
            return;
        }
        if (node.getClass() == MakeUserInstructionCommand.class || node.getClass() == ListEndCommand.class || node.getClass() == GroupEndCommand.class){
            //makeuserinstruction is the only class that is executed as it is parsed
            return;
        }
        if (node.getClass() == MakeVariableCommand.class){
            handleMakeVariableCommand(node);
            return;
        }
        if (node instanceof ControlCommand){
            handleControlCommand(node);
            return;
        }
        if (node.getClass() == GroupStartCommand.class){
            handleGroupCommand(node);
            return;
        }
        if (node.getClass() == TellCommand.class){
            handleTellCommand(node);
            return;
        }
        if (node.getClass() == AskCommand.class){
            handleAskCommand(node);
            return;
        }
        if (node instanceof TurtleCommand && !isASubCommand){
            handleTurtleCommand(node);
            return;
        }
        // any commands that need to be executed before/while children are generated happen before this point
        traverseChildren(node);
        handleAfterGenerationOfChildren(node);
    }

    private void handleTurtleCommand(Command node) {
        List<Turtle> turtleList = new ArrayList<>(backendController.getMyTurtles());
        for (Turtle t: turtleList){
            if (t.getIsTurtleActive()){
                currTurtle = t;
                isASubCommand = true;
                TurtleCommand commandCopy = (TurtleCommand) copyRecurse(node);
                traverseChildren(commandCopy);
                commandCopy.execute(backendController, t);
                isASubCommand = false;
                node.setReturnValue(commandCopy.getReturnValue());
            }
        }
    }

    private void handleTellCommand(Command node) {
        traverse(node.getChildren().get(0));
        node.execute(backendController, currTurtle);
    }

    private void handleAskCommand(Command node) {
        boolean prevTurtleState = currTurtle.getIsTurtleActive();
        traverse(node.getChildren().get(0));
        node.execute(backendController, currTurtle);
        if(node.getChildren().get(1).getClass() != ListStartCommand.class){
            //TODO "Wrong syntax error"
        }
        traverse(node.getChildren().get(1));
        currTurtle.setTurtleActive(prevTurtleState);
    }

    private void handleGroupCommand(Command node) {
        node.getChildren().get(COMMAND_INDEX).setIsEvaluated(true);
        traverseChildren(node);
        node.getChildren().get(COMMAND_INDEX).setIsEvaluated(false);
        node.execute(backendController, currTurtle);
    }

    private void handleControlCommand(Command node) {
        if (node instanceof IfCommand || node instanceof IfElseCommand) {
            handleIfCommands(node);
            return;
        }
        ControlCommand controlCom = (ControlCommand) node;
        controlCom.setInitialExpressions();
        List<Command> initExpr = controlCom.getInitialExpressions();
        boolean prevState = isASubCommand;
        isASubCommand = false;
        for (Command expr: initExpr) {
            traverse(expr);
        }
        controlCom.setUpLoop();
        while(controlCom.shouldRunAgain()) {
            controlCom.execute(backendController);
            if (controlCom.getListToRun() != null) {
                handleListStartCommand(controlCom.getListToRun());
                node.setReturnValue(controlCom.getListToRun().getReturnValue());
            }
        }
        isASubCommand = prevState;
    }

    private void handleIfCommands(Command node) {
        List<Turtle> turtleList = new ArrayList<>(backendController.getMyTurtles());
        boolean prevState = isASubCommand;
        isASubCommand = true;
        for (Turtle t: turtleList){
            if (t.getIsTurtleActive()){
                currTurtle = t;
                ControlCommand commandCopy = (ControlCommand) copyRecurse(node);
                commandCopy.setInitialExpressions();
                List<Command> initExpr = commandCopy.getInitialExpressions();
                for (Command expr: initExpr) {
                    traverse(expr);
                }
                commandCopy.execute(backendController);
                if (commandCopy.getListToRun() != null) {
                    handleListStartCommand(commandCopy.getListToRun());
                    node.setReturnValue(commandCopy.getListToRun().getReturnValue());
                }
            }
        }
        isASubCommand = prevState;
    }

    private void handleListStartCommand(Command node) {
        traverseChildren(node);
    }

    private void handleAfterGenerationOfChildren(Command node) {
        //used for methods that must execute after children have been generated (such as textcommands
        if (node.getClass() == TextCommand.class){
            handleTextCommand(node);
        }
        else if (node.getNumParameters() == node.getChildren().size()){
            if (node instanceof TurtleCommand) {
                TurtleCommand turtleCom = (TurtleCommand) node;
                turtleCom.execute(backendController, currTurtle);
            }
            if (node instanceof BasicCommand) {
                BasicCommand turtleCom = (BasicCommand) node;
                turtleCom.execute(backendController);
            }

        }
        else if (node.getNumParameters() == (int) Double.POSITIVE_INFINITY){
            // do nothing, the root command should not throw an error
        }
        else{
            throw new SyntaxError(WRONG_NUMBER_OF_PARAMETERS);//TODO replace with another exception
        }
    }


    private void handleTextCommand(Command node) {
        TextCommand textCom = (TextCommand) node;
        textCom.execute(backendController);
        traverseChildren(textCom);
        List<Command> childrenList = textCom.getChildren();
        textCom.setReturnValue(childrenList.get(childrenList.size() - 1).getReturnValue());
    }

    private void traverseChildren(Command node) {
        for (Command child : node.getChildren()) {
            traverse(child);
        }
    }

    private void handleMakeVariableCommand(Command node) {
        String name = node.getChildren().get(0).getText();
        Optional<Double> variableValue = backendController.getVariableIfExists(name);
        if (!variableValue.isPresent()) {
            var initVarCommand = new MakeVariableCommand();
            initVarCommand.addChildren(new Variable(name));
            initVarCommand.addChildren(new ConstantCommand(0.0));
            initVarCommand.execute(backendController);
        }
        traverse(node.getChildren().get(EXPRESSION_INDEX));
        BasicCommand makeVarCom = (BasicCommand) node;
        makeVarCom.execute(backendController);
    }

    private Command copyRecurse(Command command){
        Command newHeadNode;
        newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(copyRecurse(c));
        }
        return newHeadNode;
    }

}
