package Backend.Commands;

import java.util.ArrayList;

public interface CommandInterface {

    int getNumParameters();

    double execute();

    ArrayList<Command> getChildren();

    void addChildren();
}
