Design Doc for SLogo
===

## Overall Design
### Provides the high-level design goals of your project

We wanted the frontend and backend to both be separated into an external and internal part, with only the external parts communicating between them. In general, we wanted to have the frontend and backend separate and we achieved this by communicating only through two controllers (one for the backend and one for the frontend). 

Another major high level design goal of the entire project was to utilize the MVC (model-view-controller) pattern. The user interacts with `Controller` and `FrontendController` through the view, and the controllers communicate with `BackendController` to manipulate the model, which is in the `Parser` package.

For the backend, one thing that we wanted was to have all commands inherit from one class, as this would allow them all to have shared behavior and to be accessed in similar ways. We also wanted one class to be responsible for executing the commands. This was implemented through Parsecommand class which handles translating the input, removing the comments, converting the input to relevant command Classes, and finally executing the input by running all the commands.  

In the frontend, we wanted `FrontendController` to serve as the interface between the frontend and backend and make sure individual frontend components did not interact with the backend. We also wanted to abstract the modules and controls to make them both easy to debug, reduce duplication, and make adding new buttons easy. Another goal was to use the capabilities of the user's OS whenever possible. Thus, whenever the user wants to save/load a file, we let the user interface with the OS's GUI instead of using our time to create a new GUI that the user was not used to. 

### explains, in detail, how to add new features to your project
Backend: 
1) adding new commands 
     - if the command can be executed through post traversal, then user can just add the command in the turtlecommands package by extending abstract class commands. (based on the specifc type of the commands, user can extend from lower level abstrac command classes too)
     - if the command cannot be executed through post traversal(example - for, tell, etc), those commands must be added in the turtle commands and also have separate way of handling methods in the ExecuteCommand class becuase these commands do not the follow the post traversal.
Frontend: 
2) adding a new view
     - if the view is of the form of a list view, then the user can add it as a subclass of the ListModule class, and if needs to interact with list items through clicking, then it can be a subclass of the CommandsAndVars class
     - if the view is not of the form of a list view, then it can be extended from the Module class instead
     - if the view requires any data from the backend, write a method in the FrontendController to obtain the data
3) adding a new button
    - in order to create a new button, one must create a new button class inside the Control module. This button class will more than likely need to have a context (which will probably be the FrontendController) and an EventHandler.
    - create a method in FrontendController to execute action when called by the button.
    - add button instance to returnButtons() method in FrontendController
4) adding a new MenuButton
    - follow same steps as adding a new button, except extend MenuButtonControl and create an associated resourceBundle in directory "res/ButtonProperties"

### Justifies major design choices, including trade-offs (i.e., pros and cons), made in your project
Backend
1. In our original design, we did not have BackendController class because we assumed that parsercommand would not have to talk to the internal grid class. We thought executing command was the only one who would talk to the turtles and the grid; however, while working on multiple turtles and grouping, we realized the only way to traverse the tree with each command and pass on the result of the commands to the frontend knowing the list of turtles and the internal grid is to make a controller that would communicate with the frontendcontroller and hold turtle lists and userdefined commands. Thus, we implemented a backendcontroller can access all the classes in the backend and would be the only backend class that would communicate with the frontend. 


2. One major design choice made in this project was the choice to pass in the BackendController into every command. This was made out of necessity, as some commands need to be able to access more than the turtles. For example, the tell command needs to be able to create multiple different turtles, which means that it has to access the current list of turtles (held by the backendcontroller). Many other commands also have this scenario for different reasons, such as setpencolor, setpalette, and turtles.

3. In execute command, there are many different ways of executing commands in the tree, instead of just one (all with different if statements). This is due to the fact that certain commands should not be evaluated in the postorder fashion that the executecommand tree normally executes commands in. For example, ifelse commands should execute by first checking the condition, and then choosing the correct branch to take - not by executing all the children (branches) before evaluating the condition. There are many cases that fit this same situation such as makevariable, makeuserdefinedcommand, and group.

Frontend
1. Another major design choice was the creation of the `FrontendController` that interacts with the BackendController and it being placed within all the Controls and Modules. This was made because we did not want several frontend components to all be interacting with the backend. Instead, we wanted to consolidate all the necessary interaction to one place, which was the FrontendController. The main pro is that only the FrontendController will interact with the backend and with the BackendController, that means it's only interacting with one class related to the backend. The con is that means the FrontendController class will be massive in size.

2. The use of the "step" function to continuously update the views and objects associated with it was a major design choice. It limited our ability to implement the "animation" challenging extension for frontend and based on other features, limited our "frames" per second. The reason why we implemented it (pro) like that was so that the backend would not have to feed data to the frontend whenever something changed. Instead, the FrontendController takes the data every so often to relieve the backend of this duty. 

### States any assumptions or decisions made to simplify or resolve ambiguities in your the project's functionality

Backend
1. We put all the commands in one package(Turtle_Commands) instead of separting commands by functions. We first used factory to create commands, so we could divide the classes by functions; however, after changing the factory to reflection, we had to put all commands in one package.
2.  We added Microsoft paint button feature which lets users change pen color; however, because the requirement for pencolor command(user can set index for rgb colors), we did not integrate these two features. Calling pencolor command after changing pen color using microsoft button will just return the last pencolor user set by command. 

3. Group returns the command return value (of its last repeat)

4. List returns the final value

5. Undo undoes the last action of every active turtle

Frontend
1. For the menu buttons, there is an associated bundle in the resources folder
2. For every button, there is a method in FrontendController associated with the action
3. For every button, there is an image file in resources
4. Graphics Area is passed turtles already in the right position
5. Console starts out with no command history and nothing in the text field
6. Frames per second have to be low in order to allow for toggling of turtles and clicking of list items in list view modules