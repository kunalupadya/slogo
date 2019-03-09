# Slogo - Team 10 

Logo is a computer programming language designed to teach programming to children. 
It is a user-friendly, interpreted language, designed with a "low floor, high ceiling"; 
in other words, the designers of Logo intended for the language to allow novice programmers 
to get started quickly writing programs but also wanted the language to be powerful and extensive for more advanced users. 
In addition to being used to build such sophisticated programs as a compiler, Logo has also caused 
people to think differently about how to teach geometry and social science to programming.

SLogo is a simpler version of Logo where users can learn basic programming skills. SLogo shares similar 
commands and concepts with Logo and can be extend to simulate Cell Automaton. 

// Add a screenshot of the SLogo here 
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

Januario Carreiro (jjc70@duke.edu)

Kunal Upadya : BackendController, Grid, Turtle, Pen, ParsingTree, ExecuteCommand, Grouping, Recursion, additional commands

Louis Lee (dl199@duke.edu) : Palette, ParseCommand, Token, TokenConverter, LanguageSetting, Basic Commands, additional commands

David Liu (dwl23@duke.edu)

Dhanush Madabusi (dm322@duke.edu) : Control Structure Commands, Errorhandling 

# Resources Used 
Stack Overflow, Google Images, Example codes from lab

# Main Class 

Controller class 

# any data or resource files required by the project (including format of non-standard files)

#any information about using the program (i.e., command-line/applet arguments, key inputs, interesting example data files, or easter eggs)

- Frontend:

- Backend : 
1. all comments should start with # and must not have a space between the first character and #

2. running the command might take some time to display on the screen because screen is only updated 
every second. 

3. userdefined commands that are being called in other user-defined commands must be pre-defined 

#any decisions, assumptions, or simplifications you made to handle vague, ambiguous, or conflicting requirements

- Frontend:

- Backend : 

1. The way we execute the command and how we set up the parsingtree, we could not add askwith command 
because we would have to redesign the tree. 

2. We decided not to implement shape feature because we always use images which means that changing shape would
not make any difference to the image on the screen. If necessary(user wants to have a triangle ball), user can 
add the png file of a triangular ball and change the image using GUI buttons. 

3. We added Microsoft paint button feature which lets users change pen color; however, because
the requirement for pencolor command(user can set index for rgb colors), we did not integrate
these two features. Calling pencolor command after changing pen color using microsoft button
will just return the last pencolor user set by command. 

# Known bugs

- Frontend:

- Backend : 
1. Due to the fact that ask command executes commands first and applies the result to the turtles, 
all the turtles would do the same action. This is usually not a problem since ask command 
is mostly used to make set of turtles execute same action; however, when users want to 
apply different result of the command(ex - random), users would have to use the for loop to wrap 
the ask command 

2. The position of turtles may not be accurate due to the fact that for some reason, grid in the backend 
and the grid in the frontend do not match exactly. 


#any extra features included in the project

1. Microsoft Paint 

2. We implemented the bounce_ball simulation. 

#your impressions of the assignment to help improve it in the future




