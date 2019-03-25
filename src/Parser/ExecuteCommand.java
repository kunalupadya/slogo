package Parser;

import GraphicsBackend.Turtle;
import Parser.Commands.*;
import Parser.Commands.Turtle_Command.*;
import java.util.*;

/**
 * This class executes all commands by doing a post-order traversal of the ParsingTree.
 *
 * @author Dhanush Madabusi
 * @author Kunal Upadya
 * @author Louis Lee
 */
class ExecuteCommand {

    private final RootCommand headNode;
    private final BackendController backendController;
    private Turtle currTurtle;
    //determines if commands are run for all turtles or just the current turtle
    private boolean isASubTurtleCommand = false;

    ExecuteCommand(BackendController backendController, ParsingTree tree) {
        headNode = (RootCommand) tree.getRoot();
        this.backendController = backendController;
        findFirstActiveTurtle();
    }

    void runCommands() throws SLogoException{
        boolean outputToConsole = false;
        if (headNode.getChildren().size() == 1 && headNode.getChildren().get(0).getIsOutputCommand()){
            outputToConsole = true;
        }
        traverse(headNode);
        if (outputToConsole){
            Command outputCommand = headNode.getChildren().get(0);
            if (outputCommand instanceof BooleanCommand || outputCommand instanceof IsPenDownCommand || outputCommand instanceof IsShowingCommand){
                backendController.outputResultToConsole("Result: " + (outputCommand.getReturnValue() == 1));
            }
            else{
                backendController.outputResultToConsole("Result: " + outputCommand.getReturnValue());
            }
        }
    }

    private void traverse(Command node) throws SLogoException{
        if (node.getIsEvaluated() || node.getClass() == MakeUserInstructionCommand.class){ //makeUserInstruction is executed as it is parsed
            return;
        }
        if (node.getClass() == MakeVariableCommand.class){
            handleMakeVariableCommand(node);
            return;
        }
        if (node.getClass() == GroupStartCommand.class){
            handleGroupCommand((GroupStartCommand) node);
            return;
        }
        if (node.getClass() == TellCommand.class){
            handleTellCommand((BasicCommand) node);
            return;
        }
        if (node.getClass() == AskCommand.class || node.getClass() == AskWithCommand.class){
            handleAskCommands((BasicCommand) node);
            return;
        }
        if (node instanceof ListStartCommand){
            handleListStartCommand(node);
            return;
        }
        if (node instanceof ControlCommand){
            handleControlCommand((ControlCommand) node);
            return;
        }
        if (node instanceof TurtleCommand) {
            if (currTurtle == null){
                throw new ExecutionException("No turtle is currently active");
            }
            if (((TurtleCommand) node).isTurtleQuery()) {
                ((TurtleCommand) node).execute(backendController, currTurtle);
                return;
            }
            if (!isASubTurtleCommand) {
                handleTurtleCommand(node);
                return;
            }
        } // any commands that need to be executed before/while children are generated happen before this point
        traverseChildren(node);
        handleAfterGenerationOfChildren(node);
    }

    private void handleTurtleCommand(Command node) throws SLogoException{
        if (node.getChildren().size() != node.getNumParameters()){
            throw new ExecutionException(getCommandClassName(node) + " is missing one or more parameters");
        }
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

    private void handleTellCommand(BasicCommand tellCom) throws SLogoException{
        traverse(tellCom.getChildren().get(0));
        tellCom.execute(backendController);
        findFirstActiveTurtle();
    }

    private void handleAskCommands(BasicCommand askCom) throws SLogoException{
        boolean isAskCommand = (askCom.getClass() == AskCommand.class);
        var prevCurrTurtleIndex = findCurrTurtleIndex(currTurtle);
        if (askCom.getChildren().get(0).getClass() != ListStartCommand.class){
            throw new ExecutionException(getCommandClassName(askCom) + " is missing its first List parameter");
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
        } else{
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
        boolean currTurtleSet = false;
        for (int i = 0; i < turtleList.size(); i++){
            if (newActiveTurtleIndices.contains(i + 1)) {
                turtleList.get(i).setTurtleActive(true);
                if (!currTurtleSet){
                    currTurtle = turtleList.get(i);
                    currTurtleSet = true;
                }
            }
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

    private void handleGroupCommand(GroupStartCommand groupCom) throws SLogoException{
        if (groupCom.getChildren().get(0).getNumParameters() == 0 && groupCom.getChildren().size() > 2){
            throw new ExecutionException("Group command expects no parameters");
        }
        groupCom.setUpGroupMainCom();
        while(groupCom.areMoreParametersLeft()){
            groupCom.setIsEvaluated(false);
            groupCom.execute(backendController);
            Command com = groupCom.getCommandToRun();
            traverse(com);
            groupCom.setReturnValue(com.getReturnValue());
        }
    }

    private void handleControlCommand(ControlCommand controlCom) throws SLogoException{
        if (controlCom instanceof IfCommand || controlCom instanceof IfElseCommand) {
            handleIfCommands(controlCom);
            return;
        }
        controlCom.setInitialExpressions();
        for (Command expr: controlCom.getInitialExpressions()) {
            traverse(expr);
        }
        controlCom.setUpLoop();
        while(controlCom.shouldRunAgain()) {
            controlCom.execute(backendController);
            if (controlCom.getListToRun() != null) {
                handleListStartCommand(controlCom.getListToRun());
                controlCom.setReturnValue(controlCom.getListToRun().getReturnValue());
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
                for (Command expr: commandCopy.getInitialExpressions()) {
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
        node.setReturnValue(node.getChildren().get(node.getChildren().size() - 2).getReturnValue());
    }

    private void handleAfterGenerationOfChildren(Command node) throws SLogoException{
        //used for methods that must execute after children have been generated
        if (node.getClass() == TextCommand.class){
            handleTextCommand((TextCommand) node);
        } else if (node.getNumParameters() == node.getChildren().size()){
            if (node instanceof TurtleCommand) {
                ((TurtleCommand) node).execute(backendController, currTurtle);
            } else {
                ((BasicCommand) node).execute(backendController);
            }
        } else if (node.getNumParameters() != (int) Double.POSITIVE_INFINITY){ // the root command should not throw an error
            throw new ExecutionException(getCommandClassName(node) + " is missing one or more parameters");
        }
    }

    private void handleTextCommand(TextCommand textCom) throws SLogoException{
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
        traverse(node.getChildren().get(1)); //evaluate expression
        ((BasicCommand) node).execute(backendController);
    }

    private Command copyRecurse(Command command){
        Command newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(copyRecurse(c));
        }
        return newHeadNode;
    }

    private int findCurrTurtleIndex(Turtle currTurtle){
        if (currTurtle == null){
            return -1;
        }
        int index = 0;
        for (Turtle t: backendController.getMyTurtles()){
            if (currTurtle.equals(t)){
                break;
            }
            index++;
        }
        return index;
    }

    private Turtle getPrevTurtle(int index){
        if (index == -1){
            return null;
        }
        return backendController.getMyTurtles().get(index);
    }

    private void findFirstActiveTurtle(){
        for (Turtle t: backendController.getMyTurtles()){
            if (t.getIsTurtleActive()){
                currTurtle = t;
                break;
            }
        }
    }

    private String getCommandClassName(Command node){
        String currCommandClass = node.getClass().toString();
        String prefix = "class Parser.Commands.Turtle_Command.";
        return currCommandClass.substring(prefix.length());
    }
}