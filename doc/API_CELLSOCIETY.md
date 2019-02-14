## Cell Society API Critique

Dhanush Madabusi (dm322@duke.edu)

Januario Carreiro (jjc70@duke.edu)

Kunal Upadya (ku16@duke.edu)

Louis Lee (dl199@duke.edu)

David Liu (dwl23@duke.edu)

### Description

```
package CellSociety;
public class CellWATOR extends Cell { 
    public void findNextState() 
    // should be internal api
    public CellWATOR getNextLocCell()
    // should not be public
    public void setNextTurnsSurvived(double turnsSurvived)
    //should be external api
    public void setNextSharkEnergy(double energy)
    // should be external api 
    public void userSwitchState()
    // should be external api 
}
 
 
package CellSociety;
public class Simulation extends Application { 
    public Simulation() throws FileNotFoundException
    public void start(Stage stage) 
    public void setSimType(String s) 
    public Cell[][] getGrid() 
    public Map<String, String> getStateImageMap()
    public void startSimulation()
    public void pauseSimulation() 
    public void playSimulation() 
    public void stepSimulation() 
    public void resetSimulation()
    public void switchSimulation(String newSimType)    
    public void setSpeed(Double d) 
    public String getSimulationType() 
    // all of these should be private
}
 
package CellSociety;
public class CellRPS extends Cell implements Comparator<String> { 
    public void findNextState() 
    public int compare(String s1, String s2) 
    // private 
}
 
package CellSociety;
public class IntroScene extends Scene { 
      public IntroScene(Group root, double width, double height, Simulation s) //width and height params unused
      // private
            public void show(Window window) 
}
 
package CellSociety;
public class CellSegregation extends Cell {
    //should be part of internal API
      public void findNextState() 
}
 
package CellSociety;
public class UI extends Scene { 
      public UI(Group root, int width, int height, String cellShape, List<Double> paramList, Simulation s)
      // private
    public void drawGrid()
     // private
    public void drawGraph()
}
 
package CellSociety;
public class XMLAlert{ 
      public XMLAlert(String title, String header, String content)
    public XMLAlert()
    // part of the external API
    public void setText(String t, String h, String c)
    // part of the external API
    public void showAlert()
}
 
package CellSociety;
public class CellFire extends Cell { 
    //should be part of internal API
      public void findNextState() 
}
 
package CellSociety;
public class CellGameOfLife extends Cell {
    //should be part of internal API
      public void findNextState() 
}
 
package CellSociety;
public abstract class Cell { 
    //should not be part of the API
    abstract public void findNextState();
    //should be part of external API
    public String getState()
    //should be part of internal API
    public void findNeighbors(Cell[][] cell, String shapeType, String edgeType, List<Integer> neighborIndexes)
    //should be part of external API
    public String getNextState()
    //should be part of internal API
    public void setNextState(String state)
    //should be part of external API
    public void userSwitchState()
}
 
package CellSociety;
public class CellPercolation extends Cell { 
    //should be part of internal API
      public void findNextState() 
}

package CellSociety.Neighbors;
public class NeighborsSquare extends Neighbors { 
      public NeighborsSquare(int row, int col, Cell[][] grid) 
      // external public
}
 
package CellSociety.Neighbors;
abstract public class Neighbors { 
    //should be part of internal API
      public void initializeEdgeAndIndexes(String edgeType, List<Integer> neighborIndexes)
      //should be part of external API
    public List<Cell> getNeighborsList()

}
 
package CellSociety.Neighbors;
public class NeighborsTriangle extends Neighbors { 
      public NeighborsTriangle(int row, int col, Cell[][] grid) 
          // external public
}
 
package CellSociety;
    // package-private variables
public class XMLParser { 
      public XMLParser(File f) throws Exception 
    public String getSimType() 
    public String getCellShape() 
    public String getEdgeType() 
    public Map<String, String> getStateImg() 
    public Map<String, Double> getStatePercent() 
    public List<Double> getParameters() 
    public List<Integer> getNeighbors() 
    public Map<List<Integer>, String> getCellState() 
    public Integer getWidth() 
    public Integer getHeight() 
    public boolean isParseSuccess() 
    public boolean isSpecConfig() 
}
```

All the methods within the simulation class should be turned private since no other classes should be calling those methods.(internal APIs) Since this group made cell classes for each simulations, all the methods in cell class should remain as public. THe main problem we found was that this group did differentiate interanl APIs from external APIs. 
