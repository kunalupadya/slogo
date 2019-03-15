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
    private BackendController backendController;
    private Turtle currTurtle;
    //determines if commands are run for all turtles or just the current turtle
    private boolean isASubTurtleCommand = false;

    public ExecuteCommand(List<Command> commandsList, BackendController backendController) {
        ParsingTree parsingTree = new ParsingTree(commandsList, backendController);
        headNode = (RootCommand) parsingTree.getRoot();
        this.backendController = backendController;
    }

    void runCommands() {
        boolean outputToConsole = false;
        if (headNode.getChildren().size() == 1 && headNode.getChildren().get(0).getIsOutputCommand()){
            outputToConsole = true;
        }
        //post traversal starting from headNode
        try {
            traverse(headNode);
        } catch (SyntaxError e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
        if (outputToConsole){
            handleConsoleOutput();
        }
    }

    private void handleConsoleOutput() {
        Command outputCommand = headNode.getChildren().get(0);
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

    private void traverse(Command node){
        if (node.getIsEvaluated()){
            return;
        }
        if (node.getClass() == MakeUserInstructionCommand.class || node.getClass() == ListEndCommand.class || node.getClass() == GroupEndCommand.class){
            //makeuserinstruction is the only command class that is executed as it is parsed
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
        if (node instanceof TurtleCommand) {
            if (!isASubTurtleCommand) {
                handleTurtleCommand(node);
                return;
            }
            if (((TurtleCommand) node).isTurtleQuery()) {
                handleTurtleQueries(node);
                return;
            }
        }
        // any commands that need to be executed before/while children are generated happen before this point
        traverseChildren(node);
        handleAfterGenerationOfChildren(node);
    }

    private void handleTurtleQueries(Command node) {
        TurtleCommand turtleCom = (TurtleCommand) node;
        turtleCom.execute(backendController, currTurtle);
    }

    private void handleTurtleCommand(Command node) {
        List<Turtle> turtleList = new ArrayList<>(backendController.getMyTurtles());
        var prevCurrTurtleIndex = findCurrTurtleIndex(currTurtle);
        for (Turtle t: turtleList){
            if (t.getIsTurtleActive()){
                currTurtle = t;
                isASubTurtleCommand = true;
                TurtleCommand commandCopy = (TurtleCommand) copyRecurse(node);
                traverseChildren(commandCopy);
                commandCopy.execute(backendController, t);
                isASubTurtleCommand = false;
                node.setReturnValue(commandCopy.getReturnValue());
            }
        }
        currTurtle = getPrevTurtle(prevCurrTurtleIndex);
    }

    private void handleTellCommand(Command node) {
        BasicCommand tellComm = (BasicCommand) node;
        traverse(tellComm.getChildren().get(0));
        tellComm.execute(backendController);
    }

    private void handleAskCommand(Command node) {
        var prevCurrTurtleIndex = findCurrTurtleIndex(currTurtle);
        BasicCommand askCom = (BasicCommand) node;
        if (askCom.getChildren().get(0).getClass() != ListStartCommand.class){
            //TODO throw error
        }
        boolean prevState = isASubTurtleCommand;
        isASubTurtleCommand = false;
        handleListStartCommand(askCom.getChildren().get(0));
        isASubTurtleCommand = prevState;
        askCom.execute(backendController);
        List<Boolean> prevTurtleStates = getCurrentTurtleStates();
        setNewTurtleStates(askCom.getChildren().get(0));
        handleListStartCommand(askCom.getChildren().get(1));
        resetTurtleStates(prevTurtleStates);
        currTurtle = getPrevTurtle(prevCurrTurtleIndex);
    }

    private void resetTurtleStates(List<Boolean> prevTurtleStates) {
        List<Turtle> turtleList = backendController.getMyTurtles();
        for (int i = 0; i < turtleList.size(); i++){
            turtleList.get(i).setTurtleActive(prevTurtleStates.get(i));
        }
    }

    private void setNewTurtleStates(Command command) {
        Set<Integer> newActiveTurtleIndices = new HashSet<>();
        for (Command com: command.getChildren()){
            newActiveTurtleIndices.add((int) com.getReturnValue());
        }
        List<Turtle> turtleList = backendController.getMyTurtles();
        for (int i = 0; i < turtleList.size(); i++){
            turtleList.get(i).setTurtleActive(newActiveTurtleIndices.contains(i + 1));
        }
    }

    private List<Boolean> getCurrentTurtleStates() {
        List<Boolean> turtleStates = new ArrayList<>();
        for (Turtle t: backendController.getMyTurtles()){
            turtleStates.add(t.getIsTurtleActive());
        }
        return turtleStates;
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
        boolean prevState = isASubTurtleCommand;
        isASubTurtleCommand = false;
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
        isASubTurtleCommand = prevState;
    }

    private void handleIfCommands(Command node) {
        List<Turtle> turtleList = new ArrayList<>(backendController.getMyTurtles());
        var prevCurrTurtleIndex = findCurrTurtleIndex(currTurtle);
        for (Turtle t: turtleList){
            boolean prevState = isASubTurtleCommand;
            isASubTurtleCommand = true;
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
            isASubTurtleCommand = prevState;
        }
        currTurtle = getPrevTurtle(prevCurrTurtleIndex);
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

    private int findCurrTurtleIndex(Turtle currTurtle){
        List<Turtle> turtleList = backendController.getMyTurtles();
        int index = 0;
        for (Turtle t: turtleList){
            if (currTurtle.equals(t)){
                break;
            }
            index++;
        }
        return index;
    }

    private Turtle getPrevTurtle(int index){
        return backendController.getMyTurtles().get(index);
    }

}
