package Parser.Commands.Turtle_Command;


import Parser.Commands.Command;

public abstract class ControlCommand extends Command {

    boolean runAgain = false;
    int counter = 0;
    Command initialExpression = null;
    ListStartCommand listToRun = null;


    ControlCommand(){

    }

    public Command getInitialExpression(){
        return initialExpression;
    }

    public abstract void setInitialExpression();

    void setListToRun(ListStartCommand list){
        listToRun = list;
    }

    public ListStartCommand getListToRun(){
        return listToRun;
    }

    public ListStartCommand copyList(ListStartCommand command){
        return (ListStartCommand) traverse(command);
    }

    private Command traverse(Command command){

        Command newHeadNode;
        newHeadNode = command.copy();
        for (Command c: command.getChildren()){
            newHeadNode.addChildren(traverse(c));
        }
        return newHeadNode;
    }

}
