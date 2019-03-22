package Parser;

import GraphicsBackend.Turtle;
import Parser.Commands.*;
import Parser.Commands.Turtle_Command.*;
import java.util.*;

/**
 * @author Kunal Upadya
 * @author Louis Lee
 * @author Dhanush Madabusi
 */

public class ExecuteCommand {

    private static final int EXPRESSION_INDEX = 1;
    private static final int COMMAND_INDEX = 0;
    private RootCommand headNode;
    private BackendController backendController;
    private Turtle currTurtle;
    //determines if commands are run for all turtles or just the current turtle
    private boolean isASubTurtleCommand = false;


    /**
     * Constructor
     * @param backendController
     * @param tree: pasringtree
     */
    public ExecuteCommand(BackendController backendController, ParsingTree tree) {
        headNode = (RootCommand) tree.getRoot();
        this.backendController = backendController;
        currTurtle = backendController.getMyTurtles().get(0);
    }

    void runCommands() throws SLogoException{
        boolean outputToConsole = false;
        if (headNode.getChildren().size() == 1 && headNode.getChildren().get(0).getIsOutputCommand()){
            outputToConsole = true;
        }
        //post traversal starting from headNode
        traverse(headNode);
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

    private void traverse(Command node) throws SLogoException{
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
        if (node.getClass() == AskCommand.class || node.getClass() == AskWithCommand.class){
            handleAskCommands(node);
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

    private void handleTurtleQueries(Command node) throws SLogoException{
        TurtleCommand turtleCom = (TurtleCommand) node;
        turtleCom.execute(backendController, currTurtle);
    }

    private void handleTurtleCommand(Command node) throws SLogoException{
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

    private void handleTellCommand(Command node) throws SLogoException{
        BasicCommand tellComm = (BasicCommand) node;
        traverse(tellComm.getChildren().get(0));
        tellComm.execute(backendController);
        for (Turtle t: backendController.getMyTurtles()){
            if (t.getIsTurtleActive()){
                currTurtle = t;
                break;
            }
        }
    }

    private void handleAskCommands(Command node) throws SLogoException{
        boolean isAskCommand = (node.getClass() == AskCommand.class);
        var prevCurrTurtleIndex = findCurrTurtleIndex(currTurtle);
        BasicCommand askCom = (BasicCommand) node;
        if (askCom.getChildren().get(0).getClass() != ListStartCommand.class){
            String currCommandClass = askCom.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " is missing its first List parameter");
        }
        if (isAskCommand) {
            boolean prevState = isASubTurtleCommand;
            isASubTurtleCommand = false;
            handleListStartCommand(askCom.getChildren().get(0));
            isASubTurtleCommand = prevState;
        }
        askCom.execute(backendController);
        List<Boolean> prevTurtleStates = getCurrentTurtleStates();
        if (isAskCommand) {
            setNewTurtleStates(askCom.getChildren().get(0));
        }
        else{
            findNewActiveTurtles(askCom.getChildren().get(0));
        }
        handleListStartCommand(askCom.getChildren().get(1));
        resetTurtleStates(prevTurtleStates);
        askCom.setReturnValue(askCom.getChildren().get(1).getReturnValue());
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

    private void findNewActiveTurtles(Command command) throws SLogoException{
        boolean prevState = isASubTurtleCommand;
        isASubTurtleCommand = true;
        for (Turtle t: backendController.getMyTurtles()){
            Command conditionCopy = copyRecurse(command.getChildren().get(0));
            currTurtle = t;
            traverse(conditionCopy);
            t.setTurtleActive(conditionCopy.getReturnValue() != 0);
        }
        isASubTurtleCommand = prevState;
    }

    private void handleGroupCommand(Command node) throws SLogoException{
        if (node.getChildren().get(COMMAND_INDEX).getNumParameters() == 0 && node.getChildren().size() > 2){
            throw new ExecutionException("Group command expects no parameters");
        }
        GroupStartCommand groupCom = (GroupStartCommand) node;
        groupCom.setUpGroupMainCom();
        while(groupCom.areMoreParametersLeft()){
            groupCom.setIsEvaluated(false);
            groupCom.execute(backendController);
            Command com = groupCom.getCommandToRun();
            traverse(com);
            groupCom.setReturnValue(com.getReturnValue());
        }
    }

    private void handleControlCommand(Command node) throws SLogoException{
        if (node instanceof IfCommand || node instanceof IfElseCommand) {
            handleIfCommands(node);
            return;
        }
        ControlCommand controlCom = (ControlCommand) node;
        controlCom.setInitialExpressions();
        List<Command> initExpr = controlCom.getInitialExpressions();
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
    }

    private void handleIfCommands(Command node) throws SLogoException{
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

    private void handleListStartCommand(Command node) throws SLogoException{
        traverseChildren(node);
        var childrenList = node.getChildren();
        node.setReturnValue(childrenList.get(childrenList.size() - 2).getReturnValue());
    }

    private void handleAfterGenerationOfChildren(Command node) throws SLogoException{
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
        else if (node.getNumParameters() != (int) Double.POSITIVE_INFINITY){
            // the root command should not throw an error
            String currCommandClass = node.getClass().toString();
            String prefix = "class Parser.Commands.Turtle_Command.";
            String command = currCommandClass.substring(prefix.length());
            throw new ExecutionException(command + " is missing one or more parameters");
        }
    }


    private void handleTextCommand(Command node) throws SLogoException{
        TextCommand textCom = (TextCommand) node;
        textCom.execute(backendController);
        UserDefinedCommand userCom = (UserDefinedCommand) textCom.getChildren().get(0);
        handleListStartCommand(userCom.getHeadNode());
        textCom.setReturnValue(userCom.getHeadNode().getReturnValue());
    }

    private void traverseChildren(Command node) throws SLogoException{
        for (Command child : node.getChildren()) {
            traverse(child);
        }
    }

    private void handleMakeVariableCommand(Command node) throws SLogoException{
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
