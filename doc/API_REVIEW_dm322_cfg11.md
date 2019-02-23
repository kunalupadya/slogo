API Review
=====

Dhanush Madabusi (dm322)

Connor Ghazaleh (cfg11)

##Part 1

Our API design overall in my opinion was constructed very well, with good use of inheritance class hierarchies to
closely adhere to the open/close principle and allow for future features to be added. By thinking ahead about how
exactly we want our application to look like, we can map exactly what interfaces, abstract classes, and classes we would
need to accomplish our goals and allow for possible extension. Our design allows for encapsulation and data hiding
to be the best possible extent, as we detail how exactly data will flow and be passed through our program. My part
specifically deals with parsing the user input, so error cases that will occur would primarily be about incorrect commands.
I will parse the command to determine the source of the error to be able to print user-friendly information in the 
application console. I will report the type of error which can include SyntaxError, UnrecognizedCommand, 
MissingParameter, WrongNumberofParameters, IncorrectParameterType, MissingCommand, etc.


##Part 2

I think we can further utilize polymorphism to accomplish our design goals and achieve clean code without code smells.
We will soon have a better idea of classes we want to add or design changes we might make once we begin to code a larger
portion of the program. I am eager to complete my part of the project in the back end and create a well structured set
of classes that takes care of the command parsing and executing effectively.

* Use Case 1: The user enters a valid command into the console **OR** The user runs a file of commands using the `Editor` feature and the command sent to `ParseCommand` is a valid command.
    
    Example command: fd 50
    
    `ParseCommand` reads the input string and splits string into list of command arguments. Methods determine whether command is recognized (based on selected language and based on user-defined commands). Since command name is valid, method checks for valid parameter and valid number of parameters. Since command parameter is valid, the command arguments are sent to `ExecuteCommand`, which updates the the turtle's properties, creates new variables or user-defined commands, or returns result of some math or boolean operations. The command is then added to the CommandHistory.
    
* Use Case 2: The user enters a invalid command into the console **OR** The user runs a file of commands using the `Editor` feature and the command sent to `ParseCommand` is a invalid command by the Consol.
    
    Example command: turnleft 10
    
    `ParseCommand` reads the input string and splits string into list of command arguments. Methods determine whether command is recognized (based on selected language and based on user-defined commands). Since command name is invalid, the command is sent to `HandleError`, which determines what type of error has occured. Errors include SyntaxError, UnrecognizedCommand, MissingParameter, WrongNumberofParameters, IncorrectParameterType, MissingCommand, etc. `HandleError` prints a user-friendly message to the console to report the error. The command is then added to the CommandHistory by the Console.