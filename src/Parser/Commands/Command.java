package Parser.Commands;

import java.util.ArrayList;

public interface Command{

    int numParameters();

    ArrayList<Command> addChildrenList();

    Command addChildren();

}
