package Parser.Commands.Turtle_Command;

import Parser.Commands.Command;
import Parser.Commands.Variable;
import java.util.List;

/**
 * Implemented by UserDefinedCommand. Ensures that a UserDefinedCommand cannot be altered once it is created in the
 * application.
 *
 * @author kunalupadya
 */
public interface ImmutableUserDefinedCommand {

    boolean getIsOutputCommand();

    double getReturnValue();

    String getText();

    List<Variable> getVariables();

    ListStartCommand getHeadNode();

    Command copy();
}
