package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;
import Parser.Commands.Variable;
import java.util.List;

public interface ImmutableUserDefinedCommand {
    boolean getIsOutputCommand();

    double getReturnValue();

    String getText();

    List<Variable> getVariables();

    ListStartCommand getHeadNode();

    Command copy();
}
