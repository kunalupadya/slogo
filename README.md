# Slogo - Team 10 

Logo is a computer programming language designed to teach programming to children. 
It is a user-friendly, interpreted language, designed with a "low floor, high ceiling"; 
in other words, the designers of Logo intended for the language to allow novice programmers 
to get started quickly writing programs but also wanted the language to be powerful and extensive for more advanced users. 
In addition to being used to build such sophisticated programs as a compiler, Logo has also caused 
people to think differently about how to teach geometry and social science to programming.

SLogo is a simpler version of Logo where users can learn basic programming skills. SLogo shares similar 
commands and concepts with Logo and can be extend to simulate Cell Automaton. 

![SLogo Application Example](doc/SLogoApplication.png?raw=true "SLogo")

# Members 

Dhanush Madabusi (dm322@duke.edu)

Januario Carreiro (jjc70@duke.edu)

Kunal Upadya (ku16@duke.edu)

Louis Lee (dl199@duke.edu)

David Liu (dwl23@duke.edu)

# TimeLine 

Start Date: 2019/02/14 

Finish Date: 2019/02/26 (first sprint) 2019/03/08 (Second Sprint)

Hours Spent: 100+ (each)

# Primary Roles

Januario Carreiro (jjc70@duke.edu) : All Controls within GUI Package, FrontendController, Controller, a little bit in Modules

Kunal Upadya (ku16@duke.edu) : BackendController, Grid, Turtle, Pen, ParsingTree, ExecuteCommand, Grouping, Recursion, additional commands

Louis Lee (dl199@duke.edu) : Palette, ParseCommand, Token, TokenConverter, LanguageSetting, Basic Commands, additional commands

David Liu (dwl23@duke.edu) : All Modules within GUI Package, FrontendController, Controller, a little bit in Controls

Dhanush Madabusi (dm322@duke.edu) : ExecuteCommand, All Basic and Extended Command classes, ParseCommand, Exception Classes, 
Error Handling, a little bit in ParsingTree

# Resources Used 

Stack Overflow, Google Images, Example codes from lab

# Main Class 

Controller class 

# Any data or resource files required by the project (including format of non-standard files)

All resource files that are necessary are found in the res folder, which should be labelled as the resources
root. All data files that are necessary are found in the data folder. Every single one of the data and resource
files are required and can be used at some point in the SLogo process. 

# Any information about using the program (i.e., command-line/applet arguments, key inputs, interesting example data files, or easter eggs)

- Frontend:
1. Use the bottom line that has the prompt text, "Enter Command:" to enter the command

2. Clicking an available variable or a user-defined command will place it in the console, ready to 
be sent with new inputted parameters or a new value.

3. Hovering over controls at the top gives their new, which can also represent a helpful description

4. You have to click the run button, rightward facing triangle, in order to run editor code

- Backend : 
1. all comments should start with #

2. running the command might take some time to display on the screen because screen is only updated 
every second. 

3. userdefined commands that are being called in other user-defined commands must be pre-defined 

# Any decisions, assumptions, or simplifications you made to handle vague, ambiguous, or conflicting requirements

- Frontend:

1. The user would want this layout, as there is no way to change this layout other than by closing modules.
In essence, there's no way to open new ones or rearrange them. 

2. The Turtle Display module is the same size as the grid kept track of in the backend.

3. The set amount for moving the turtle left, right, forward, and back is 10.

4. Variables and user-defined commands and labels are not "translated" when switching languages,
which partly would not make sense anyways since those parts do not need translation.

- Backend : 

1. We decided not to implement shape feature because we always use images which means that changing shape would
not make any difference to the image on the screen. If necessary(user wants to have a triangle ball), user can 
add the png file of a triangular ball and change the image using GUI buttons. 

2. We added Microsoft paint button feature which lets users change pen color; however, because
the requirement for pencolor command(user can set index for rgb colors), we did not integrate
these two features. Calling pencolor command after changing pen color using microsoft button
will just return the last pencolor user set by command. 

3. Group returns the command return value (of its last repeat)

4. List returns the final value

5. Undo undoes the last action of every active turtle

6. Ask and Askwith can be called within each other

# Known bugs

- Frontend:
1. All the text turns red if there is an error being printed in the console history and black 
if it's a valid command/set of commands instead of them being separate colors (errors = red, black
for everything else)

2. Buttons can disappear if the size of the window decreases (by closing). The layout is also messed
up in general the user tries to make the window smaller manually.

3. Window is tiny on a 4K computer, meaning it's based on pixels and not well adjusted based on
pixel dimensions on a computer screen.

4. Turtle and pen lines can get out of the Turtle Display area by a few pixels

- Backend : 

1. The position of turtles may not be accurate due to the fact that for some reason, grid in the backend 
and the grid in the frontend do not match exactly.

2. Recursion is functional, but program crashes when procedure has multiple recursive calls 

# Any extra features included in the project

1. Microsoft Paint 

2. We implemented the bounce_ball simulation. 

3. Implemented a console such that it's like a real console, where pressing the up and down arrows
go to your previously run commands/code.

4. Implemented an editor that takes and/or reads in a file of commands

# Your impressions of the assignment to help improve it in the future

We thought the assignment was very well-rounded with distinct front-end and back-end components
that helped divide the work up. However, we were not able to get a portion of the basic 
implementation completely done by the basic implementation date. Especially given that it was due on a 
Wednesday, it compounded that issue. I would rather have that part due a little later while still 
having the complete implementation due along the same timeline as the current setup. Basically give 
a couple more days for basic and take away the same amount from complete. In terms of incorporating
what we learned in class and through the readings, we thought this assignment provided ample opportunities
for that and we believed we took advantage of that. This assignment let us experience a nice challenge
with rewarding design benefits.




