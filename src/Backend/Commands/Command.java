package Backend.Commands;

import java.util.ArrayList;

public abstract class Command{


    int getNumParameters();

    double execute();

    ArrayList<Command> getChildren();

    void addChildren();

}
