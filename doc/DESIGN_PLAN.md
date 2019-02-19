Design Plan
===

Dhanush Madabusi (dm322@duke.edu)

Januario Carreiro (jjc70@duke.edu)

Kunal Upadya (ku16@duke.edu)

Louis Lee (dl199@duke.edu)

David Liu (dwl23@duke.edu)

# Introduction

We are to make a different version of SLOGO IDE so that it can be adjusted to serve mulitple purposes(New window, additional instructions, reading in an existing file etc). In order to do this, we will have four APIs, external and interanl APIs for both front-end and back-end. Both internal APIs will be closed, but the externals would be left open to be used from other parts of the code. Front end external will handle inputs that will be sent to the back-end internal API. The back-end external API will take care of the imaginary Grid(screen) where we will store data and etc. Front-end internal will hold all components related to GUI. 

# Design Overview

The front end internal will consist of `WindowLayoutManager`, and a few `Window` subclasses. The `WindowLayoutManager` class interacts with the different window classes and `Driver` with the move(), setPane() and setWindow() public classes. The user will also interact with the program through `WindowLayoutManager` if he/she decides to change the program layout. The front end external will consist of the `Button` subclasses and certain `Window` subclasses such as `Console`. Each button has a public method action() that activates when a user clicks on the window. The `Button` subclass more likely than not then interacts with the `ParseCommand` or `ExecuteCommand` classes. `Console` should be communicating with `ParseCommand` every time the user presses `enter`. The back end internal will consist of `ConfigurationParser` and `ParseCommand`. These two methods will delegate the rest of the backEnd work to the other classes. The back end external will consist of several back end classes, including but not limited to `Grid`, `Turtle`, `ExecuteCommand`, `HandleError`, and `LanguageSetting`. These will have several different methods that will communicate with `Console`, `GraphicsArea`, and `WindowLayoutManager`.

![SLogo UML](https://i.imgur.com/dDbByKH.png)



# User Interface

The overall appearance of most of the program's user interface components will appear like a "window". Examples such as listing the previous commands, listing the available variables, and others can be part of their own "window". For the components that are just displaying information, the user will interact by closing it, minimizing it/maximizing it, and having a option in making the window bigger to a set size and decreasing it to the original size. For the console and editor windows, the user can interact by typing in commands, create new commands, and run previous commands. Non-windows will consist of a toolbar with buttons to supplement the process such as undo, redo, switch languages, and others. An image of the planned user interface is shown below.

![](https://i.imgur.com/W7pu8HX.png)


# API Details 

Front end: On the front end side of things, the way the graphical interface will be separated from the interpreter is through the use of the abstract class `Window`. There are several windows that don't need to interact directly with the interpreter, save for knowing a command list, such as AvailableVars and Help. Other windows will consistently communicate with the interpreter through parsers or backend graphics. The console window will interact with parsers such as HandleError, ExecuteCommand, and ParseCommand. The GraphicsArea window will interact with the backend graphics classes, such as the turtle, pen, and grid which houses the turtle and pen objects. The console will be the main object used for communicating between the user's needs and the graphical interface. The other secondary user interaction will be through the buttons. They will help control graphical features other than commanding the turtle, such as changing the pen color, setting the turtle image, and switching the command language. In essence, the combination of the console/editor and buttons will serve to communicate with the interpreter (parser) and other backend components.

Back end: The external backend subsists of three classes: `Grid`, `Turtle`, and `Pen`. All three of these classes serve the purpose of storing values that will be accessed from the frontend. The turtle class stores the location, speed, image, and direction of the turtle, and has methods for moving to a certain position on the grid, setting speed, changing direction, or changing image. The Pen object will be instantiated and acessed by the turtle, and during movement if the pen is down then the turtle will leave a trail of whatever the pen color is on the grid. The grid will store all of the pen marks made by the turtle, and will be able to send an immutable copy of itself to the frontend. The frontend will directly be able to interact with the turtle and the grid to draw on the graphical area, and will be able to access the pen to determine the active color.

Front end: Currently, we are required to have several different "windows", one where the user can see the turtle executing commands, another where the user can see commands previously run in the environment, and another where the user can see variables currently available in the environment. In the complete implimentation, we might have to make more windows, so we are making a `Window` abstract class and having the different windows extend that class. The `Window` classes will mostly not be closed to manipulation. We might also be expected to have more buttons, so we will be making `Button` class and all buttons will extend that abstract class. The `Button` classes will be closed to manipulation. With those two abstractions, most new features should be simple to add to the program. Most of the buttons will not throw any errors, but the user interacting with certain classes may cause errors to be thrown. For example, if the user types a bad command in the `Console` window, the command is sent to handleError(), but that is part of FrontEnd external, and not internal. In short, we do not expect many errors to be thrown due to the user manipulating the front end internal incorrectly. 

Back end: This will all be in the package `parser`. We plan to have five classes in this package where each class would have only one purpose. Since we will be handling all commands through ExecuteCommand class, execute command class could be an abstract class with subclasses handling each commands. In this way, if new commands were to be added, we would only have to add more subclasses. Other classes such as `ConfigParser` and `ParseCommand` would stay as one class.

# API Example Code
Dhanush Madabusi

* Use Case 1: The user enters a valid command into the console **OR** The user runs a file of commands using the `Editor` feature and the command sent to `ParseCommand` is a valid command.
    
    Example command: fd 50
    
    `ParseCommand` reads the input string and splits string into list of command arguments. Methods determine whether command is recognized (based on selected language and based on user-defined commands). Since command name is valid, method checks for valid parameter and valid number of parameters. Since command parameter is valid, the command arguments are sent to `ExecuteCommand`, which updates the the turtle's properties, creates new variables or user-defined commands, or returns result of some math or boolean operations. The command is then added to the CommandHistory.
    
* Use Case 2: The user enters a invalid command into the console **OR** The user runs a file of commands using the `Editor` feature and the command sent to `ParseCommand` is a invalid command by the Consol.
    
    Example command: turnleft 10
    
    `ParseCommand` reads the input string and splits string into list of command arguments. Methods determine whether command is recognized (based on selected language and based on user-defined commands). Since command name is invalid, the command is sent to `HandleError`, which determines what type of error has occured. Errors include SyntaxError, UnrecognizedCommand, MissingParameter, WrongNumberofParameters, IncorrectParameterType, MissingCommand, etc. `HandleError` prints a user-friendly message to the console to report the error. The command is then added to the CommandHistory by the Console.

Januario Carreiro
* Use Case 1: The user presses the SetPenColor button and is able to select a color from the color wheel for the turtle.

    To add the button to the screen, we will use the following code:
    ```
    setPenColor = new SetPenColor(this);
    setPenColor.getView().setLayoutX(<<location>>);
    setPenColor.getView().setLayoutY(<<location>>);
    setPenColor.getView().setTooltip(new Tooltip("Change the color of the turtle's pen"));
    ```
    We will not need to write a setOnMouseClick() method after initializing the button because the class that all buttons will extend will the following line in their constructor:
    ```
    this.icon.setOnMouseClicked(mouseEvent -> onClick());
    ```
    Every `Button` subclass will then overwrite the onClick() method.
    
    After the user selects a color from the colorwheel, the setPenColor object will communicate with the ExecuteCommand class and NOT the Pen class. ExecuteCommand is the class that will handle most all user inputs from the console class and from the buttons.
    
    The code will be similar to:
    
    ```
    ExecuteCommand.setPenColor(chosenColor);
    ```
* Use Case 2: The user extends the `Editor` window pressing the "extend" button at the top of a window.

    The program screen will have several different "windows" that the user can interact with, including an editor where the user can write several lines of code and then press `Run` for the code to be executed. When a user presses the Extend button, code similar to the following will be executed:
    ```
    public void onClick() {
        context.showExtendedEditor();
    }
    ```
    
    Where `context` is probably going to be `WindowLayoutManager`. In `WindowLayoutManager` there will be a method, of course, called showExtendedEditor(). The code will be similar to:
    ```
    public void showExtendedEditor() {
        extendedEditor = new Group();
        
        Window editor = new Editor(<<Paramters>>);
        
        ...
        
        extendedEditor.getChildren().addAll(<<Objects to be added to this Group>>);
        extendedEditor.setLayoutY(<<location>>);
        extendedEditor.setLayoutX(<<location>>);
        myContainer.getChildren().add(extendedEditor);
    }
    ```
    Since `Editor` is itself a `Group`, all we are really doing is making a larger Editor object in a new location and most of the code needed to create all the parts of the Editor object are dealt with in the `Editor` class. 

Kunal Upadya
* Use Case 1: Command fd 50 is parsed with the pen down and black

    The parser should execute command by telling the turtle to move forward 50. This will be called like
    ```
    turtle.move(50);
    ```
    which will call a method that takes the current direction of the turtle and moves in that direction on the grid. Within the move method, there will be a method call like 
    ```
    myGrid.set(self.x, self.y, pen.getColor());
    ```
    Where `getColor` looks something like this:
    ```
    if (penDown){
        return pen.getColor();
    }
    else{
        return GRID_COLOR;
    }
    ```
    
    The frontend will then update by getting the location and direction of the turtle, as well as the colored in grid. This can be done by calling
    ```
    grid = myGrid.get()
    turtleX = turtle.getX()
    turtleY = turtle.getY()
    turtleDir = turtle.getDirection()
    ```
    This should give the frontend everything they need to display the graphics.
    
* Use Case 2: Command rt 90 is parsed - how is the frontend updated?
    A command like 
    ```
    turtle.turn(90);
    ```
    is called in the executeCommand block.
    This causes the turtle to update like
    ```
    turtleDir += 90;
    ```
    
    Which is then accessed by the frontend by commands such as
    ```
    turtleDir = turtle.getDirection();
    ```

Louis Lee
* Use Case 1: XML parser that reads in basic commands XML, different language setting XML, User defined functions saved as XML, in a map(commands and language) or a string.  
```
File file = new File(filepath);
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
DocumentBuilder dBuilder = dbf.newDocumentBuilder();
Document doc = dBuilder.parse(file);
doc.getDocumentElement().normalize();

for(info size){add to the map}
```
After creating a map, Parsecommand will only have to look within a map, to get neccesary info related to the command. 

* Use Case 2: ParseCommand class which will receive string from the console and loop up the map to find the necessary command info. If the command does not exist, it will create error messages. 
```
foo value = map.get(console_string);
if(value == null){
    if(object not defined) handleerror(objectnotdefined);
    if(wrong syntax) handleerror(Syntax error);
    etc;
}
else{command_info = map.get(console_string)};
```
I will be using regex to determine different kinds of errors. The map will be stored in the parsecommand class. 

David Liu

* Use Case 1: Within the Console, the user presses the up arrow to access previous command input attempts. 

    Based on how the `Console` window functions, this operation will need to utilize the CommandHistory class to obtain the previous command the up arrow should go to. The console should have access to a list of commands available from the CommandHistory class, something along the lines of
    ```
    CommandHistory commands;
    List myCommands;
    
    # initialize CommandHistory somewhere here
    
    public List<String> getCommands() {
        myCommands = commands.getList();
    }
    ```
    Based on the `Console` function and the up arrow, there should be a "handleKeyInput" function for the Window itself that is connected to the group associated with it. An int is initialized as a way to accomplish getting the previous command, but can be optimally designed in the future. 
    ```
    <console's group>.setOnKeyReleased(event -> handleKeyInput(event.getCode()));
    
    ...
    
    int i; # changes based on where someone is on the previous command list
    
    private void handleKeyInput(KeyCode code) {
        if (code = KeyCode.UP) {
            <Clear the console of the command written right now>
            <Current Console Text> = myCommands.get(i);
            i--;
        }
    }
    
    ```

* Use Case 2: The user closes the `AvailableVars` window pressing the "close" button at the top of a window.

    The program screen will have several different "windows" that the user can interact with, including an AvailableVars window where the user can see the available variables in the environment. When a user presses the Close button, code similar to the following will be executed:
    ```
    public void onClick() {
        context.close(myAvailableVars);
    }
    ```
    
    Where `context` is probably going to be `WindowLayoutManager`. In `WindowLayoutManager` there will be a method, of course, called close(). The code will be similar to:
    ```
    public void close(Group availableVars) {
        myContainer.getChildren().remove(availableVars);
    }
    ```
    Since `AvailableVars` is itself a `Group`, all we are really doing is removing the group from the overall scene.

# Design Considerations 

- Throughout the design making process, especially with the UML Diagram, we had to make many key decisions. 
    - We decided first the abstraction of the GUI and where we would consider this. We decided that given the amount of "windows" available on the screen, it would make sense to include a `Window` abstract class, with several subclasses. 
    - A tough decision made was where to include the Turtle, Pen, and Grid classes, and how to connect those graphics with other parts of the project. We ended up making all of it part of the same package and connecting it to the GraphicsArea window, which would localize its affect to one window. We thought localizing it would prevent any unnecessary parts of the project having access to the turle, pen, and grid. 
    - We had to decide how and where the parser would interact with the Console (shell), and we ended up deciding that Console would mediate this with ParseCommand, ExecuteCommand, and HandleError. We thought it was critical to make sure only specific actions would affect the Console. 
    - Finally, we had to decide how the GUI's "windows" would be able to control themselves, and settled on having a WindowLayoutManager class control the layout of the entire screen with all the windows. We thought this would be easier than having the window abstract class having this ability and having to know the size of other windows to try and fit itself in the overall scene.
- One ambiguity that will have to be addressed is the definition of a command. Will we necessarily need to include it as a class or just keep it stored in one of the classes as a list? If it is a class, how will that affect the overall design? The dependencies can be seen by the non-triangular tipped arrows in the UML diagram. 

# Team Responsibilities

Dhanush Madabusi 
- Primary role: Back End (parser)
 `ParseCommand`,`ExecuteCommand`, `HandleError`, `LanguageSetting`, `ConfigurationParser`

Januario Carreiro 
- Primary role: Front End (driver)
`Driver`, `WindowLayoutManager`, `Controls`,`Buttons`

Kunal Upadya 
- Primary role: Back End (graphics)
`Grid`, `Pen`, `Turtle`

Louis Lee 
- Primary role: Back End (parser)
`ParseCommand`, `ExecuteCommand`, `HandleError`, `LanguageSetting`, `ConfigurationParser`

David Liu 
- Primary role: Front End (windows)
`Window` and its subclasses, `Buttons`
- Secondary role: Front End (driver)
`Driver`, `WindowLayoutManager`, `Controls`, `Buttons`

The team will work mainly with their primary roles, with the back end team (Dhanush, Kunal, Louis) and front end team (Januario, David) working separately. Within each team, each member has distinct classes or interfaces that he/she will mainly work on. Overlap and discussion of the implementation of classes and interfaces will occur mostly within the two teams. After both teams have completed most of their implementation for a sprint, there will be meetings focusing on integration between key classes, such as Console and HandleError/ExecuteCommand among others. From there, there will continue to be back and forth dialogue among all members. 