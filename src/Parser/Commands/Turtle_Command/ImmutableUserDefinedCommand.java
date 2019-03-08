package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;
import Parser.Commands.Variable;

import java.util.List;

public interface ImmutableUserDefinedCommand {
    public int getCurrentNumParameters();

    public boolean getIsEvaluated();

    public int getNumParameters();

    public double getReturnValue();

    public String getText();

    public List<Variable> getVariables();

    public ListStartCommand getHeadNode();

    public Command copy();
}
