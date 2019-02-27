package Parser.Commands;

import java.util.ArrayList;

public interface Command{

    int numParameters();

    double execute();

    ArrayList<Command> getChildren();

    void addChildren();

}
